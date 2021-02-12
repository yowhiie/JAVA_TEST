package com.mini.bank.dto;

import java.util.List;

import com.mini.bank.model.TransactionType;

import lombok.Data;

@Data
public class TransactionTypeDto {
    private String transactionTypeId;
    private String transaction;
    private List<TransactionType> transactionTypeList;
}
