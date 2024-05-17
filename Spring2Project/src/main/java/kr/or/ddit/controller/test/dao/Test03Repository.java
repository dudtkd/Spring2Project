package kr.or.ddit.controller.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.controller.test.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Test03Repository {

	private List<StudentVO> studentList = new ArrayList<StudentVO>();
	
	private String[] ids = {"a001","b001","c001","d001","e001","f001"};
	private String[] pws = {"1234","1234","1234","12345","1234","1234"};
	private String[] names = {"안희재","김현태","김나혜","김영상","최현명","신하림"};
	private String[] phones = {
		"011-1122-4783","016-4734-1523","010-1234-1234","019-9879-2243","010-4536-1234",
		"010-7564-4352"
	};
	
	public Test03Repository() {
		// StudentVO를 활용하여 403호 학생 5명을 초기화해주세요.
		for(int i = 0; i < ids.length; i++) {
			StudentVO student = new StudentVO();
			student.setMemId(ids[i]);
			student.setMemPw(pws[i]);
			student.setMemName(names[i]);
			student.setMemEmail(ids[i] + "@naver.com");
			student.setMemPhone(phones[i]);
			studentList.add(student);
			
			
			
		}
	}
	
	// 기능구현
	// - 학생 전체 가져오기
	public List<StudentVO> studnetList(){
		log.info("studentList  >>>> :" + studentList);
		
		return studentList;
	}
	
	// - 학생 한명 정보 가져오기
	public StudentVO selectOne(StudentVO student) {
		
		 for(int i = 0; i < studentList.size(); i++) {
			 StudentVO member = studentList.get(i);
			 if(studentList.get(i).getMemId().equals(student.getMemId()) && studentList.get(i).getMemPw().equals(student.getMemPw()) ) {

				 
				 log.info("테스트03다오 " + member);
				 		
				 return member;
			 }
		 }
		 return null;
	}

	// - 이름, 이메일 정보를 활용해 학생 아이디 가져오기
	public String findId(StudentVO student) {

		String memName = student.getMemName();
		String memEmail = student.getMemEmail();
		log.info("여기는 아이디 찾기 다오" + memName);
		log.info("여기는 아이디 찾기 다오" + memEmail);
		 for(int i = 0; i < studentList.size(); i++) {
			 String memId = studentList.get(i).getMemId();
			 if(studentList.get(i).getMemName().equals(student.getMemName()) && studentList.get(i).getMemEmail().equals(student.getMemEmail())) {

				 
				 
				 log.info("테스트03다오 " + memId);
				 		
				 return memId;
			 }
		 }
		 return null;
	}


	// - 아이디, 이름, 이메일 정보를 활용해 학생 비밀번호 가져오기
	public String findPw(StudentVO student) {

		String memId = student.getMemId();
		String memName = student.getMemName();
		String memEmail = student.getMemEmail();
		
		log.info("비밀번호 찾기 다오 >>>>" + memId);
		log.info("비밀번호 찾기 다오 >>>>" + memName);
		log.info("비밀번호 찾기 다오 >>>>" + memEmail);
		
		for (int i = 0; i < studentList.size(); i++) {
			String memPw = studentList.get(i).getMemPw();
			if(studentList.get(i).getMemId().equals(student.getMemId()) && studentList.get(i).getMemName().equals(student.getMemName())	&& studentList.get(i).getMemEmail().equals(student.getMemEmail())) {
				
				log.info("비밀번호 찾기 다오 비번>>>>" + memPw);
				return memPw;
				
			}
		}
		
		return null;
	}
	
	
	
	// 등등 필요에 의한 기능을 구현해주세요.
	
	
	
}
