package com.project.fraud.detection.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.fraud.detection.v1.model.TransactionData;

public interface TransactionRepository extends JpaRepository<TransactionData, String> {
	
//    @Query("SELECT t FROM TransactionData t WHERE t.accountNumber = :accountNumber AND ABS(TIMESTAMPDIFF(MINUTE, t.transactionTime, :currentTime)) <= 5")
//    List<TransactionData> findTransactionsWithinFiveMinutes(@Param("accountNumber") String accountNumber, @Param("currentTime") String currentTime);

}
