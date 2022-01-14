//package com.p2.recApp.springemailclient;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//
//import javax.mail.MessagingException;
//
//@SpringBootApplication
//public class SpringEmailClientApplication {
//
//	@Autowired
//	private EmailSenderService service;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringEmailClientApplication.class, args);
//	}
//
////	@EventListener(ApplicationReadyEvent.class)
////	public void triggerMail() throws MessagingException {
////
////		service.sendSimpleEmail("qwinkypoo@gmail.com",
////				"This is Email Body....here is your lame password",
////				"This is the Email Subject.. Boooooo_H@NN@H");
////
////	}
//}