package com.proj2.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj2.model.User;

public interface LoginService {
	
	User attemptAuthentication(HttpServletRequest request, HttpServletResponse response);
}
