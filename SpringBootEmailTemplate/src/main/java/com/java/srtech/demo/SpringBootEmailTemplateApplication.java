package com.java.srtech.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.java.srtech.mail.service.EmailSenderService;
import com.java.srtech.model.Mail;

@SpringBootApplication
@ComponentScan("com.java.srtech")
public class SpringBootEmailTemplateApplication implements ApplicationRunner{
	
	@Autowired
    private EmailSenderService emailService;
	
	private static Logger log = LoggerFactory.getLogger(SpringBootEmailTemplateApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailTemplateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("START... Sending email");

        Mail mail = new Mail();
        mail.setFrom("xxxxx");//replace with your desired email
        mail.setMailTo("xxxxx");//replace with your desired email
        mail.setSubject("Email with Spring boot and thymeleaf template!");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "User!");
        model.put("location", "India");
        model.put("sign", "SR Technolgies Pvt Ltd");
        mail.setProps(model);

        emailService.sendEmail(mail);
        log.info("END... Email sent success");
		
	}
}
