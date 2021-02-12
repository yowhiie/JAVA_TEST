package com.mini.bank.service;

import java.util.List;

import com.mini.bank.constants.Constants;
import com.mini.bank.model.User;
import com.mini.bank.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;
    private TransactionHistoryService transactionHistoryService;

    @Autowired
    public UserService(UserRepo userRepo, TransactionHistoryService transactionHistoryService) {
        this.userRepo = userRepo;
        this.transactionHistoryService = transactionHistoryService;
    }

    public List<User> getAllUser() {
        List<User> userList = userRepo.findAll();
        return userList;
    }

    public User getUser(String userId) {
        return userRepo.getOne(Integer.parseInt(userId));
    }

    public User withdraw(String userId, int amount) {
        User userToUpdate = userRepo.getOne(Integer.parseInt(userId));
        if (userToUpdate.getBalance() > amount) {
            int newBalance = userToUpdate.getBalance() - amount;
            userToUpdate.setBalance(newBalance);
        } else {
            System.out.println("insufficient balance");
        }

        transactionHistoryService.saveTransactionHistory(amount, Constants.TRANSACTION_WITHDRAW, userId);
        return userRepo.save(userToUpdate);
    }

    public User deposit(String userId, int amount) {
        User userToUpdate = userRepo.getOne(Integer.parseInt(userId));
        userToUpdate.setBalance(userToUpdate.getBalance() + amount);

        transactionHistoryService.saveTransactionHistory(amount, Constants.TRANSACTION_DEPOSIT, userId);
        return userRepo.save(userToUpdate);
    }

    public User transfer(String userIdSender, String userIdReceiver, int amount) {
        User userSender = userRepo.getOne(Integer.parseInt(userIdSender));
        int newBalance = userSender.getBalance() - amount;
        userSender.setBalance(newBalance);
        userRepo.save(userSender);

        User userReceiver = userRepo.getOne(Integer.parseInt(userIdReceiver));
        newBalance = userReceiver.getBalance() + amount;
        userReceiver.setBalance(newBalance);

        transactionHistoryService.saveTransactionHistory(amount, Constants.TRANSACTION_TRANSFER, userIdSender);
        return userRepo.save(userReceiver);
    }
}
