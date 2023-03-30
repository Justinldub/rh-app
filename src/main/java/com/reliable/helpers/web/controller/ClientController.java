package com.reliable.helpers.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@CrossOrigin
@Controller
public class ClientController {
	
	
	@RequestMapping(value = "/index.html",method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/client-register-employee.html",method = RequestMethod.GET)
	public String addClientDetilsEmployee() {
		return "client-register-employee";
	}
	
	@RequestMapping(value = "/client-register-employer.html",method = RequestMethod.GET)
	public String addClientDetilsEmployer() {
		return "client-register-employer";
	}
	
	@RequestMapping(value = "/about.html",method = RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value = "/contact.html",method = RequestMethod.GET)
	public String contanct() {
		return "contact";
	}
	@RequestMapping(value = "/join-us.html")
	public String join_us() {
		return "join-us";
	}
	
}
