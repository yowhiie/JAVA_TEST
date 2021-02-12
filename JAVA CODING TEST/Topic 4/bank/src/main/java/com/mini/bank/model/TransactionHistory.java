package com.mini.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TRANSACTION_HISTORY")
@Data
public class TransactionHistory {
    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "AMOUNT")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_TYPE_ID")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
