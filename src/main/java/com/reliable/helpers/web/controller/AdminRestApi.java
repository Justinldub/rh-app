package com.reliable.helpers.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reliable.helpers.web.model.Agreement;
import com.reliable.helpers.web.model.AgreementStatus;
import com.reliable.helpers.web.model.Contract;
import com.reliable.helpers.web.model.Duration;
import com.reliable.helpers.web.model.Job;
import com.reliable.helpers.web.model.JobRoles;
import com.reliable.helpers.web.model.JobStatus;
import com.reliable.helpers.web.model.JobTitle;
import com.reliable.helpers.web.model.Languages;
import com.reliable.helpers.web.model.Mail;
import com.reliable.helpers.web.model.Nationality;
import com.reliable.helpers.web.model.NewsMail;
import com.reliable.helpers.web.model.Race;
import com.reliable.helpers.web.model.Role;
import com.reliable.helpers.web.model.User;
import com.reliable.helpers.web.service.AdminService;

@RestController
@CrossOrigin
public class AdminRestApi {

	
	private static final String API = "/api";
	
	@Autowired AdminService us;
	
	@GetMapping(API+"/get-contract")
	public ResponseEntity<Contract[]> getContractTypes(){
		return new ResponseEntity<>(Contract.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-job-roles")
	public ResponseEntity<JobRoles[]> getjobRoles(){
		return new ResponseEntity<>(JobRoles.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-job-status")
	public ResponseEntity<JobStatus[]> JobStatus(){
		return new ResponseEntity<>(JobStatus.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-job-titles")
	public ResponseEntity<JobTitle[]> getJobTitles(){
		return new ResponseEntity<>(JobTitle.values(),HttpStatus.OK);
	}
	@GetMapping(API+"/get-agreement-status")
	public ResponseEntity<AgreementStatus[]> getAgreementStatus(){
		return new ResponseEntity<>(AgreementStatus.values(),HttpStatus.OK);
	}
	
	
	@PostMapping(API+"/register-user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		System.out.println(user.getAddress().toString());
		return new ResponseEntity<>(us.saveUser(user),HttpStatus.OK);
	}
	@GetMapping(API+"/get-users")
	public ResponseEntity<Iterable<User>> getAllUsers(){
		return new ResponseEntity<>(us.getAllUser(),HttpStatus.OK);
	}
	@GetMapping(API+"/get-user/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable int id){
		return new ResponseEntity<>(us.getUserByID(id),HttpStatus.OK);
	}
	@GetMapping(API+"/get-job/{id}")
	public ResponseEntity<Job> getJobByID(@PathVariable int id){
		return new ResponseEntity<>(us.getJobByID(id),HttpStatus.OK);
	}
	@GetMapping(API+"/get-agreement/{id}")
	public ResponseEntity<Agreement> getAgreementByID(@PathVariable int id){
		return new ResponseEntity<>(us.getAgreementByID(id),HttpStatus.OK);
	}
	@GetMapping(API+"/get-roles")
	public ResponseEntity<Role[]> getAllRoles(){
		return new ResponseEntity<>(Role.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-languages")
	public ResponseEntity<Languages[]> getAllLanguages(){
		return new ResponseEntity<>(Languages.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-races")
	public ResponseEntity<Race[]> getAllRaces(){
		return new ResponseEntity<>(Race.values(),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-duration")
	public ResponseEntity<Duration[]> getAllDurations(){
		return new ResponseEntity<>(Duration.values(),HttpStatus.OK);
	}
	@GetMapping(API+"/get-nationality")
	public ResponseEntity<Nationality[]> getAllNationalities(){
		return new ResponseEntity<>(Nationality.values(),HttpStatus.OK);
	}
	@PostMapping(API+"/save-mail")
	public ResponseEntity<NewsMail> saveMail(@RequestBody NewsMail mail){
		return new ResponseEntity<>(us.saveMail(mail),HttpStatus.OK);
	}
	@PostMapping(API+"/send-mail")
	public ResponseEntity<String> sendMail(@RequestBody Mail mail){
		
		return new ResponseEntity<>(us.sendSimpleMail(mail),HttpStatus.OK);
	}
	@PostMapping(API+"/create-agreement/{emp_id}")
	//@RequestMapping(method = RequestMethod.POST,value = API+"/create-agreement/{emp_id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Agreement> createAgreement(@RequestBody Agreement agreement, @PathVariable int emp_id){
		return new ResponseEntity<>(us.employerAgreement(agreement,emp_id),HttpStatus.OK);
	}
	
	@PostMapping(API+"/create-job/{agr_id}")
	public ResponseEntity<Job> createJob(@RequestBody Job job, @PathVariable int agr_id){
		return new ResponseEntity<>(us.saveJob(job, agr_id),HttpStatus.OK);
	}
	
	@GetMapping(API+"/get-all-jobs")
	public ResponseEntity<Iterable<Job>>getAllJobs(){
		return new ResponseEntity<>(us.getJobs(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(API+"/get-all-agreements")
	public ResponseEntity<Iterable<Agreement>>getAllAgreements(){
		return new ResponseEntity<>(us.getAgreements(),HttpStatus.ACCEPTED);
	}
	
}



