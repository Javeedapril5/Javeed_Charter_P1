package com.reward.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reward.calculator.model.Customer;

/**
 * Repository for the Customer entity.
 * @author atulsingh
 *
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
