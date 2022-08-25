package com.kuzin.fraud.service;

import com.kuzin.fraud.models.FraudCheckHistory;
import com.kuzin.fraud.repo.FraudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FraudService {

    @Autowired
    private final FraudRepo fraudRepo;

    public FraudService(FraudRepo fraudRepo) {
        this.fraudRepo = fraudRepo;
    }

    public boolean isFraudulentCustomer(Long id){
        fraudRepo.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(id)
                        .createdAt(LocalDate.now())
                            .build()
        );
        return false;
    }
}
