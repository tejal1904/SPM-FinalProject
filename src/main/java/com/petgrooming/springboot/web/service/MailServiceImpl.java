package com.petgrooming.springboot.web.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petgrooming.springboot.web.model.Appointment;

@Transactional
@Service("mailService")
public class MailServiceImpl implements MailService{
	
	@Autowired
	AppointmentService appointmentService;
	
	@Override
	public void sendMail() {
		
		List<Appointment> appointmentList = appointmentService.getAppointmentForMail();
		String from = "tom.petgroomer@gmail.com";
		String password = "tomhanks123";
		String sub = "Reminder - You have an appointment tomorrow for your Pet";
		String msg ="Hello, <br/><br/> This is to remind you about your appointment with Tom for tomorrow. Please be available at home during your appointment.<br/> <br/> <br/> Regards, <br/> Tom";
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {   
        	 MimeMessage message = new MimeMessage(session);  
        	 message.setSubject(sub);    
             //message.setText(msg); 
        	 message.setContent(msg, "text/html");
             message.addRecipient(Message.RecipientType.TO,new InternetAddress("tjadhav@student.unimelb.edu.au"));      
             //send message  
             Transport.send(message); 
	        /* for(Appointment appointment:appointmentList) {
	             message.addRecipient(Message.RecipientType.TO,new InternetAddress(appointment.getClient().getEmail()));      
	             //send message  
	             Transport.send(message); 
	         }*/
           
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
		
	}

}
