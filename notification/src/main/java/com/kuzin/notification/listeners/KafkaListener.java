package com.kuzin.notification.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuzin.notification.dto.EmailMessage;
import com.kuzin.notification.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KafkaListener {


    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    ObjectMapper mapper;

    @org.springframework.kafka.annotation.KafkaListener(topics = "finish-registration", groupId = "finish-reg")
    void registrationListener(String data) throws JsonProcessingException {

        EmailMessage emailMessage = mapper.readValue(data, EmailMessage.class);
        System.out.println(emailMessage);
        //emailSenderService.sendEmail(emailMessage.getAddress(), emailMessage.getTheme().toString(),
         //       "Hello, confirm your registration ");


    }

}
