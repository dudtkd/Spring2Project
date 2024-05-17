package kr.or.ddit.collection;

import java.util.ArrayList;
import java.util.List;

public class Manage {

	private List<PersonVO> list = new ArrayList<PersonVO>();
	
	public void addPersonVO(PersonVO personVO) {
		
		if(!list.contains(personVO)) {
			list.add(personVO);
		}
		
	}
	
	public void printList() {
		for(PersonVO personVO:list) {
			System.out.println(personVO);
		}
	}
	
	
	public static void main(String[] args) {
		Manage manage = new Manage();
		
		StudentVO studentVO1 = new StudentVO("홍길동", 10, "남자",3,3,10);

		StudentVO studentVO2 = new StudentVO("유관순", 12, "여자",4,1,15);
		
		StudentVO studentVO3 = new StudentVO("강감찬", 15, "남자",6,5,25);

		PersonVO teacherVO1 = new TeacherVO("김수학", 35, "남자", "정교사", "담임교사");
		
		PersonVO teacherVO2 = new TeacherVO("이영어", 45, "여자", "기간제", "일반교사");

		
		
		
		
		manage.addPersonVO(studentVO1);
		manage.addPersonVO(studentVO2);
		manage.addPersonVO(studentVO3);
		
		manage.addPersonVO(teacherVO1);
		manage.addPersonVO(teacherVO2);
		
		manage.printList();
		
		PersonVO personVO = new PersonVO();
		personVO.setName("강감찬");
		
		PersonVO resultPersonVO = manage.selectPersonVO(personVO);
		System.out.println("resultPersonVO : " + resultPersonVO);
		
		int cnt = manage.deletePersonVO(personVO);
		System.out.println("삭제 건수 : " + cnt);
		
		manage.printList();
		
	}
	
	public int deletePersonVO(PersonVO personVO) {
		int cnt = 0;
		
//		for (int i = 0; i < list.size(); i++) {
//			
//			if(list.get(i).getName().equals(personVO.getName())) {
//				
//				list.remove(i);
//				
//				cnt++;
//			}
//			
//		}
		
		if(this.list.remove(personVO)) {
			cnt++;
		}
		return cnt;
	}
	
	
	public PersonVO selectPersonVO(PersonVO personVO) {
		PersonVO result = null;
		
//		for(PersonVO person:list) {
//			
//			if(person.getName().equals(personVO.getName())){
//				
//				result = person;
//			}
//			
//		}
		
		int index = this.list.indexOf(personVO);
		System.out.println(index);
		if(index > -1 ) {
			result = this.list.get(index);
		}
		
		return result;
	}
	
}
