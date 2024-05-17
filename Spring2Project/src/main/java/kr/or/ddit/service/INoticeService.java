package kr.or.ddit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.PaginationInfoVO;
import kr.or.ddit.vo.crud.NoticeFileVO;
import kr.or.ddit.vo.crud.NoticeMemberVO;
import kr.or.ddit.vo.crud.NoticeVO;

public interface INoticeService {

	public ServiceResult insertNotice(HttpServletRequest req, NoticeVO noticeVO);

	public NoticeVO selectNotice(int boNo);

	public ServiceResult updateNotice(HttpServletRequest req, NoticeVO noticeVO);

	public ServiceResult noticeDelete(HttpServletRequest req, int boNo);

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ServiceResult idCheck(String memId);

	public ServiceResult signup(HttpServletRequest req, NoticeMemberVO memberVO);

	public NoticeMemberVO loginCheck(NoticeMemberVO memberVO);

	public NoticeFileVO noticeDownload(int fileNo);

	public NoticeMemberVO selectMember(String memId);

	public ServiceResult profileUpdate(HttpServletRequest req, NoticeMemberVO memberVO);

	/////////////////////// 아이디 찾기 , 비밀번호 찾기
	
	public String findId(String memEmail, String memName);

	public String findPw(String memId, String memEmail, String memName);

}
