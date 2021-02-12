package com.mini.bank.repository;

import com.mini.bank.model.TransactionType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepo extends JpaRepository<TransactionType, Integer> {

}
