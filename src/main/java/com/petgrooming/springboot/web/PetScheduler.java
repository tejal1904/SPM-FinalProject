package com.petgrooming.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.petgrooming.springboot.web.service.MailService;

@Component
public class PetScheduler {
	
	@Autowired
	MailService mailService;
	
	@Scheduled(fixedDelay = 24 * 60 * 60 * 1000)
	public void sendMail() {
		mailService.sendMail();
	}

}
