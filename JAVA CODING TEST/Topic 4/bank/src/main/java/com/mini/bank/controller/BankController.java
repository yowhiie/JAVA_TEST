package com.mini.bank.controller;

import java.util.List;

import com.mini.bank.model.TransactionHistory;
import com.mini.bank.model.User;
import com.mini.bank.service.TransactionHistoryService;
import com.mini.bank.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    private UserService userService;
    private TransactionHistoryService transactionHistoryService;

    @Autowired
    public BankController(UserService userService, TransactionHistoryService transactionHistoryService) {
        this.userService = userService;
        this.transactionHistoryService = transactionHistoryService;
    }

    @GetMapping("/getCount")
    public int getCount() {
        int count = userService.getAllUser().size();
        return count;
    }

    @PostMapping("/withdraw")
    public User transact(String userId, int amount) {
        return userService.withdraw(userId, amount);
    }

    @PostMapping("/deposit")
    public User deposit(String userId, int amount) {
        return userService.deposit(userId, amount);
    }

    @PostMapping("/transfer")
    public User transfer(String senderId, String receiverId, int amount) {
        return userService.transfer(senderId, receiverId, amount);
    }

    @GetMapping("/transactionHistory/{id}")
    public List<TransactionHistory> getTransactionHistory(@PathVariable String userId) {
        return transactionHistoryService.getAllTransactionHistory(userId);
    }
}
