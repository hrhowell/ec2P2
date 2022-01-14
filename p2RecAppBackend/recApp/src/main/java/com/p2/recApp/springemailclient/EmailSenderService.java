package com.p2.recApp.springemailclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    
    public void sendSimpleEmail(String message) {
    	
    }

    public void sendSimpleEmail(String toEmail, String body, String subject) {
        
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("thymecrunchtechteam@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        System.out.println("Mail Sent");
    }
public void sendRecipeEmail(String toEmail, String body, String subject) {
        
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("thymecrunchtechteam@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        System.out.println("Mail Sent");
    }
public void sendSignUpEmail(String toEmail, String body, String subject) {
    
	SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("thymecrunchtechteam@gmail.com");
    message.setTo(toEmail);
    message.setSubject(subject);
    message.setText(body);
    mailSender.send(message);
    System.out.println("Mail Sent");
}

    public void sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("thymecrunchtechteam@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem
                = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send...");

    }
}
