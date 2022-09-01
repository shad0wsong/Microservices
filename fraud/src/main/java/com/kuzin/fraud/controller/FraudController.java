package com.kuzin.fraud.controller;

import com.kuzin.fraud.service.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kuzin.fraud.responses.FraudCheckResponse;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    @Autowired
    private  FraudService fraudService;

    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable(value = "customerId") Long customerId) {
        boolean isFraudster=fraudService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudster);
    }

}
