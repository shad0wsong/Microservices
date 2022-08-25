package com.kuzin.customer.repo;

import com.kuzin.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
