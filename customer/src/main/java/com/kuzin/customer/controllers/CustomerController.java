package com.kuzin.customer.controllers;

import com.kuzin.customer.exception.FraudsterException;
import com.kuzin.customer.models.Customer;
import com.kuzin.customer.requests.CustomerRegistrationRequest;
import com.kuzin.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) throws FraudsterException {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
