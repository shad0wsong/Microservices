package com.kuzin.customer.service;

import com.kuzin.customer.enums.EmailTheme;
import com.kuzin.customer.exception.FraudsterException;
import com.kuzin.customer.models.Customer;
import com.kuzin.customer.repo.CustomerRepo;
import com.kuzin.customer.requests.CustomerRegistrationRequest;
import com.kuzin.customer.requests.EmailMessage;
import com.kuzin.customer.responses.FraudCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    KafkaTemplate<String, EmailMessage> kafkaTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) throws FraudsterException {
        Customer customer=Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepo.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse=restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
         );
        if(fraudCheckResponse.isFraudster()){
            throw new FraudsterException("fraudster");
        }
        EmailMessage emailMessage= new EmailMessage();
        emailMessage.setTheme(EmailTheme.FINISH_REGISTRATION);
        emailMessage.setAddress(request.email());
        kafkaTemplate.send("finish-registration", emailMessage);
    }

        //todo:check if email valid
        //todo :check if email not taken
        //todo :check if fraudster
        //todo : send notification

    }

