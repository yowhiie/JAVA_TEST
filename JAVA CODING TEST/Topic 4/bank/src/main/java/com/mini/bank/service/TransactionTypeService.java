package com.mini.bank.service;

import com.mini.bank.model.TransactionType;
import com.mini.bank.repository.TransactionTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionTypeService {
    private TransactionTypeRepo transactionTypeRepo;

    @Autowired
    public TransactionTypeService(TransactionTypeRepo transactionTypeRepo) {
        this.transactionTypeRepo = transactionTypeRepo;
    }

    public TransactionType getTransactionType(String type) {
        TransactionType transactionType = transactionTypeRepo.getOne(Integer.parseInt(type));
        return transactionType;
    }
}
