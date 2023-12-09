package com.booking.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.booking.dto.userDto;
import com.booking.service.userService;

public class LoginRedirectHandler implements AuthenticationSuccessHandler {

	@Autowired
	private userService userService; // UserService는 실제 사용자 정보를 가져오는 서비스여야 합니다.

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// 사용자 이름을 가져오는 예시 (실제로는 사용자 정보를 어떻게 가져올지에 따라 변경)
		String username = authentication.getName();

		try {
			// 사용자 정보를 DB 또는 다른 방법으로 가져오기
			userDto userDto = userService.getUserByUsername(username);

			if (userDto != null) {
				// 로그인 성공
				System.out.println("Login successful for user: " + username);

				// 세션에 사용자 정보 저장
				HttpSession session = request.getSession();
				session.setAttribute("userses", userDto);

				// 사용자 권한 체크
				List<String> roleNames = new ArrayList<>();
				authentication.getAuthorities().forEach(authority -> {
					roleNames.add(authority.getAuthority());
					System.out.println("==role.authority==" + authority.getAuthority());
				});

				// 원하는 작업 수행
				// 예: 특정 권한이 있을 경우 다른 페이지로 리다이렉트
				if (roleNames.contains("ROLE_ADMIN")) {
					response.sendRedirect("/app/");
				} else {
					response.sendRedirect("/app/");
				}
			} else {
				// 사용자 정보를 가져오지 못한 경우, 로그인 실패 처리
				System.out.println("실패실패");
				response.sendRedirect("/user/login?error");
			}
		} catch (Exception e) {
			// 예외 발생 시 로그인 실패 처리
			e.printStackTrace();
		}
	}
}