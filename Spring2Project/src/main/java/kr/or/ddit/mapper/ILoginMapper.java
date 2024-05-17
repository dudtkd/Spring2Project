package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.crud.NoticeMemberVO;

public interface ILoginMapper {

	public NoticeMemberVO idCheck(String memId);

	public int signup(NoticeMemberVO memberVO);

	public void signupAuth(int memNo);

	public NoticeMemberVO loginCheck(NoticeMemberVO memberVO);

	public String findId(@Param("memEmail") String memEmail, @Param("memName") String memName);

	public String findPw(@Param("memId") String memId, @Param("memEmail") String memEmail, @Param("memName") String memName);

	public NoticeMemberVO readByUserId(String username);

}
