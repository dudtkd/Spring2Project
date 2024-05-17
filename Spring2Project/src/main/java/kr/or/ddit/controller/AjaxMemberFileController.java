package kr.or.ddit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/ajax")
public class AjaxMemberFileController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "/registerFileForm", method = RequestMethod.GET)
	public String ajaxRegisterFileForm() {
		log.info("ajaxRegisterFileForm() 실행..!");
		return "member/ajaxRegisterFile";
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, 
			produces= "text/plain; charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file){
		String originalFileName = file.getOriginalFilename();
		log.info("uploadAjax() 실행...!");
		log.info("originalFileName : " + originalFileName);
		return new ResponseEntity<String>("UPLOAD SUCCESS", HttpStatus.OK);
		
	}
	
}
