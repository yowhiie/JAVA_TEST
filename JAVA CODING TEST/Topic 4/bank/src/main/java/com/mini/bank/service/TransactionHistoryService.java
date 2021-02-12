package com.mini.bank.service;

import java.util.List;

import com.mini.bank.model.TransactionHistory;
import com.mini.bank.model.TransactionType;
import com.mini.bank.model.User;
import com.mini.bank.repository.TransactionHistoryRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionHistoryService {
    private TransactionHistoryRepo transactionHistoryRepo;
    private TransactionTypeService transactionTypeService;
    private UserService userService;

    @Autowired
    public TransactionHistoryService(TransactionHistoryRepo transactionHistoryRepo,
            TransactionTypeService transactionTypeService, UserService userService) {
        this.transactionHistoryRepo = transactionHistoryRepo;
        this.transactionTypeService = transactionTypeService;
        this.userService = userService;
    }

    public TransactionHistory saveTransactionHistory(int amount, String transactionTypeId, String userId) {
        TransactionType transactionType = transactionTypeService.getTransactionType(transactionTypeId);
        User user = userService.getUser(userId);
        TransactionHistory transactionHistory = new TransactionHistory();

        transactionHistory.setAmount(amount);
        transactionHistory.setTransactionType(transactionType);
        transactionHistory.setUser(user);

        return transactionHistoryRepo.save(transactionHistory);
    }

    public List<TransactionHistory> getAllTransactionHistory(String userId) {
        return transactionHistoryRepo.findAllByUserId(Integer.parseInt(userId));
    }
}
