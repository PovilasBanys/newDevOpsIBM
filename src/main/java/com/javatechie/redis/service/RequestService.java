package com.javatechie.redis.service;


import javax.servlet.http.HttpServletRequest;


public interface RequestService {
	
	String getClientIp(HttpServletRequest request);
	
}