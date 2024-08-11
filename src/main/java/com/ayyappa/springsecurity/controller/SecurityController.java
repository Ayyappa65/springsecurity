package com.ayyappa.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	public String greet(HttpServletRequest request)
	{
		return "Welcome to ayyappa web application "+" your session id is : " + request.getSession().getId();
	}

}
