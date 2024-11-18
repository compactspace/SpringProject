package com.spring.FormSecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class FormLogOutHandler implements LogoutHandler{

	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println("씨발 로그앗 호출되냐");
		authentication.getAuthorities().removeAll(null);
	}

}
