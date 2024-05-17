package kr.or.ddit.controller.crud;

public class BoardRecordNotFoundException extends Exception {

	public BoardRecordNotFoundException(String msg	) {
		// 부모인 Exception으로 사용자가 정의한 메세지를 전달한다.
		super(msg);
	}
}
