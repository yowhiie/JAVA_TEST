package com.mini.bank.dto;

import com.mini.bank.model.TransactionType;
import com.mini.bank.model.User;

import lombok.Data;

@Data
public class TransactionHistoryDto {
    private String transactionId;
    private int amount;
    private TransactionType transactiontype;
    private User user;
}
