package com.reliable.helpers.web.repo;

import com.reliable.helpers.web.model.Mail;

public interface EmailRepo {
	String sendSimpleMail(Mail mail);
}
