package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;

@Controller
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static Logger log = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		log.info("### Login Success");
	
		authentication.getPrincipal();
		
		User customUser = (User) authentication.getPrincipal();
		
		// 인증이 완료된 사용자 ID 꺼내기
		log.info("### username : " + customUser.getUsername());
		// 인증이 완료된 사용자 PW 꺼내기
		log.info("### password : " + customUser.getPassword());
		
		// 세션에 등록되어 있는는 인증 과정에서 발생한 에러 정보를 삭제
		clearAuthenticationAttribute(request);
		
		SavedRequest saveRequest = requestCache.getRequest(request, response);
		String targetUrl = "/"; // 초기값을 빈값으로 잡아주면 else문을 쓸 필요가 없음
		if(saveRequest != null) {	// 타겟 정보가 존재함
			targetUrl = saveRequest.getRedirectUrl();
		}
		
		log.info("Login Success targetUrl : " + targetUrl);
		response.sendRedirect(targetUrl);
		
	}

	private void clearAuthenticationAttribute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if(session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	
	
}
