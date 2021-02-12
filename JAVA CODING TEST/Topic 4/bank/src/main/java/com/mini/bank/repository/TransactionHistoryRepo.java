package com.mini.bank.repository;

import java.util.List;

import com.mini.bank.model.TransactionHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Integer> {

    @Query(value = "SELECT * FROM TransactionHistory WHERE userId = ?1", nativeQuery = true)
    List<TransactionHistory> findAllByUserId(int userId);

}
