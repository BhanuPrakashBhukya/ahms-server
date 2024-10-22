package com.plea11.ahms.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author bhukyabhanuprakash
 * */

@Service
public class EmailService {

    private final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail(String receiver, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bhanuprakash8082@gmail.com");
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
        log.info("Email sent successfully to " + receiver);
    }

}
