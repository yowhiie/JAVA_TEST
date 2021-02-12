package com.mini.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TRANSACTION_TYPE")
@Data
public class TransactionType {
    @Id
    @Column(name = "TRANSACTION_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionTypeId;

    @Column(name = "TRANSACTION")
    private String transaction;
}
