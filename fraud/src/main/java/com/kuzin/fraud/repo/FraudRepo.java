package com.kuzin.fraud.repo;

import com.kuzin.fraud.models.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepo extends JpaRepository<FraudCheckHistory,Long> {
}
