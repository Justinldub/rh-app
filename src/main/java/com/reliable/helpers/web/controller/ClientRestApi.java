package com.reliable.helpers.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reliable.helpers.web.model.Languages;
import com.reliable.helpers.web.model.Mail;
import com.reliable.helpers.web.model.NewsMail;
import com.reliable.helpers.web.model.Role;
import com.reliable.helpers.web.model.User;
import com.reliable.helpers.web.service.UserService;

@RestController
@CrossOrigin
public class ClientRestApi {

	
	private static final String API = "/api";
	
	@Autowired UserService us;
	
	@PostMapping(API+"/register-user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		System.out.println(user.getAddress().toString());
		return new ResponseEntity<>(us.saveUser(user),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-roles")
	public ResponseEntity<Role[]> getAllRoles(){
		return new ResponseEntity<>(Role.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-languges")
	public ResponseEntity<List<Languages>> getAllLanguages(){
		return new ResponseEntity<>(us.loadLanguages(),HttpStatus.OK);
	}
	
	@PostMapping(API+"/save-mail")
	public ResponseEntity<NewsMail> saveMail(@RequestBody NewsMail mail){
		return new ResponseEntity<>(us.saveMail(mail),HttpStatus.OK);
	}
	@PostMapping(API+"/send-mail")
	public ResponseEntity<String> sendMail(@RequestBody Mail mail){
		
		return new ResponseEntity<>(us.sendSimpleMail(mail),HttpStatus.OK);
	}
}



