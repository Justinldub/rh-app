package com.reliable.helpers.web.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.reliable.helpers.web.Main;
import com.reliable.helpers.web.model.Agreement;
import com.reliable.helpers.web.model.Blog;
import com.reliable.helpers.web.model.Job;
import com.reliable.helpers.web.model.Languages;
import com.reliable.helpers.web.model.Mail;
import com.reliable.helpers.web.model.NewsMail;
import com.reliable.helpers.web.model.User;
import com.reliable.helpers.web.repo.AgreementRepo;
import com.reliable.helpers.web.repo.BlogRepo;
import com.reliable.helpers.web.repo.EmailRepo;
import com.reliable.helpers.web.repo.JobRepo;
import com.reliable.helpers.web.repo.NewsMailRepo;
import com.reliable.helpers.web.repo.UserRepo;








@Service
public class AdminService implements EmailRepo{

	
	
	
	
	
	
	
	
	@Autowired UserRepo ur;
	@Autowired NewsMailRepo nmr;
	@Autowired JavaMailSender mailSender;
	@Autowired JobRepo jr;
	@Autowired AgreementRepo ar;
	@Autowired BlogRepo br;
	//@Value("${spring.mail.username}") private  String sender;
	public User saveUser(User user){
		
		return ur.save(user);
	}
	
	public Iterable<User> getAllUser(){
		return ur.findAll();
	}
	public NewsMail saveMail(NewsMail mail){
		return nmr.save(mail);
	}
	public Job saveJob(Job job) {
		return jr.save(job);
	}
	public Job getJobByID(int id) {
		return jr.getReferenceById(id);
	}
	public User getUserByID(int id) {
		return ur.getReferenceById(id);
	}
	public Agreement employerAgreement(Agreement agreement,int emp_id) {
		agreement.setEmployer(ur.getReferenceById(emp_id));
		
		return ar.save(agreement);
	}
	
	public Agreement employeeAgreement(Agreement agreement,int emp_id) {
		agreement.setEmployee(ur.getReferenceById(emp_id));
		
		return ar.save(agreement);
	}
	public Agreement getAgreementByID(int id) {
		return ar.getReferenceById(id);
	}
	public Job saveJob(Job job, int agr_id) {
		
		job.setTitle(ar.getReferenceById(agr_id).getTitle());
		job.setAgreement(ar.getReferenceById(agr_id));
		Agreement a =	ar.getReferenceById(agr_id);
		jr.save(job);
		a.setJob(job);
		ar.saveAndFlush(a);
		return job;
	}
	
	@Override
	public String sendSimpleMail(Mail mail) {
		// TODO Auto-generated method stub
		try{
		SimpleMailMessage m = new SimpleMailMessage();
		m.setFrom(mail.getFrom());
		m.setTo(mail.getTo());
		m.setText(mail.getMessage());
		m.setSubject(mail.getSubject());
		mailSender.send(m);
		return "email was sent";
		}catch(Exception e){
			e.printStackTrace();
			return  "error while trying to send message";
		}
	}
	public Languages[] loadLanguages(){
		return Languages.values();
	}
	
	public Iterable<Job> getJobs(){
		return jr.findAll();
	}
	
	public Iterable<Agreement> getAgreements(){
		return ar.findAll();
	}
	public Iterable<Blog> getAllBlogs(){
		return br.findAll();
	}
	public Blog saveBlog(Blog blog) {
		return br.save(blog); 
	}
		
}
