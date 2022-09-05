package com.reliable.helpers.web.model;

public class Mail {
 private String to;
 private String from;
 private String message;
 public String subject;
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public Mail(String to, String from, String message, String subject) {
	super();
	this.to = to;
	this.from = from;
	this.message = message;
	this.subject = subject;
}

 
}
