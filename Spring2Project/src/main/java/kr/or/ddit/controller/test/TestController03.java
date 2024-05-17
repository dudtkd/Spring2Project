package kr.or.ddit.controller.test;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.controller.test.dao.Test03Repository;
import kr.or.ddit.controller.test.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test03")
@Slf4j
public class TestController03 {

	@Inject
	private Test03Repository dao;
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginPage() {
		return "script/test03/login";
	}
	
	@RequestMapping(value="/findInfo.do", method = RequestMethod.GET)
	public String findInfo() {
		return "script/test03/findInfo";
	}
	
	@RequestMapping(value="/info.do", method = RequestMethod.GET)
	public String info(HttpSession session) {
		
		log.info("여기는  인포임 ?>>>>>" + session.getAttribute("member"));
		return "script/test03/info";
	}

	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, StudentVO student, RedirectAttributes ra ) {
		
		
		StudentVO memberInfo = dao.selectOne(student);
		
		if(memberInfo != null) {
			log.info("컨트롤러에서 VO 출력해보는중 >>>>>>>>" + memberInfo);
			session.setAttribute("member", memberInfo);
			ra.addFlashAttribute("msg", memberInfo.getMemName()+"님! 환영합니다");
			return "redirect:/test03/info.do";
		}else {
			
		}
		
		ra.addFlashAttribute("error", "로그인에 실패 하였습니다.");
		
		return "redirect:/test03/login.do";
	}
	
	// ResponseEntity<String>타입은 응답에 대한 결과값과 상태값(두개)을 같이 보내줄 수 있다.
	@RequestMapping(value = "/findId.do" , method = RequestMethod.POST)
	public ResponseEntity<String> findId(@RequestBody StudentVO student) {
		
		String memId = dao.findId(student);
		
		log.info("아이디 찾기 컨트롤러 " + memId);
		if (memId == null) {
			// 만약 아이디를 찾지 못한 경우
			return new ResponseEntity<String>("FAILD", HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<String>(memId, HttpStatus.OK);
	    }
	}
	
	
	@RequestMapping(value = "/findPw.do", method = RequestMethod.POST)
	public ResponseEntity<String> findPw(@RequestBody StudentVO student){
		
		String memPw = dao.findPw(student);
		
		log.info("비밀번호 찾기 컨트롤러 " + memPw);
		if(memPw == null) {
			return new ResponseEntity<String>("FAILD",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(memPw, HttpStatus.OK);
		}
		
	}
	
	
	
}
