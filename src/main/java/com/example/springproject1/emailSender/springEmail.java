package com.example.springproject1.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class springEmail {
    @Autowired
    private  EmailSenderService senderService;
    public static void main(String[] args){
        SpringApplication.run(springEmail.class,args);   }

    @EventListener(ApplicationReadyEvent.class)
    public  void sendMail(){
        senderService.sendMail("yefrniseifff@gmail.com","this is subject","this is body");
    }
}
