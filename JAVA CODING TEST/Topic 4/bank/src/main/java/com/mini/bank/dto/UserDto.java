package com.mini.bank.dto;

import java.util.List;

import com.mini.bank.model.User;

import lombok.Data;

@Data
public class UserDto {
    private String userId;
    private int balance;
    private List<User> userList;
}
