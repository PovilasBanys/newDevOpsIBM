package com.javatechie.redis.controller;

import com.javatechie.redis.respository.ProductDao;
import com.javatechie.redis.service.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

	@Autowired
	private RequestService requestService;

	@Autowired
	private ProductDao dao;

	@RequestMapping("/address")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("index");
		String clientIp = requestService.getClientIp(request);
		model.addObject("clientIp", clientIp);
		return model;
}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		String addressCount = dao.countIp();
		model.addObject("addressCount", addressCount);
		return model;
	}
}

