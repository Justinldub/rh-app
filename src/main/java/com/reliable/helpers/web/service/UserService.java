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
import com.reliable.helpers.web.model.Languages;
import com.reliable.helpers.web.model.Mail;
import com.reliable.helpers.web.model.NewsMail;
import com.reliable.helpers.web.model.User;
import com.reliable.helpers.web.repo.EmailRepo;
import com.reliable.helpers.web.repo.NewsMailRepo;
import com.reliable.helpers.web.repo.UserRepo;








@Service
public class UserService implements EmailRepo{

	
	
	
	
	
	
	
	
	@Autowired UserRepo ur;
	@Autowired NewsMailRepo nmr;
	@Autowired JavaMailSender mailSender;
	@Value("${spring.mail.username") private  String sender;
	public User saveUser(User user){
		return ur.save(user);
	}
	
	public Iterable<User> getAllUser(){
		return ur.findAll();
	}
	public NewsMail saveMail(NewsMail mail){
		return nmr.save(mail);
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
	public List<Languages> loadLanguages(){
		File file = new File(Main.class.getResource("languages.txt").getFile());
		List<Languages> languages = new ArrayList<>();
		if(file.exists()){
			Scanner fileIn = null;
			try{
				fileIn = new Scanner(file);
				String line = "";
				while(fileIn.hasNext()){
					StringTokenizer str = new StringTokenizer(line,"\t");
					int id = Integer.parseInt(str.nextToken());
					String name = str.nextToken();
					languages.add(new Languages(id,name));
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return  languages;
	}
}
