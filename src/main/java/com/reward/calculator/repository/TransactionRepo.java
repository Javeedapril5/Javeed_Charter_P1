package com.reward.calculator.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reward.calculator.model.Transaction;

/**
 * Repository for Transaction entity. Used for different CRUD Operation
 * 
 * @author atulsingh
 *
 */
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	/**
	 * JPQL for getting the Transaction for customer Id and date range
	 * @param status
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Query("SELECT t FROM Transaction t WHERE t.customer.customerId = ?1 and t.transactionDate between ?2 and ?3")
	List<Transaction> getTransactionByCustIdAndDate(Long customerId, Date beginDate, Date endDate);
}
