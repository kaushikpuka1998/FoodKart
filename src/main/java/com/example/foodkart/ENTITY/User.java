package com.example.foodkart.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class User {
    private String name;
    private String gender;
    private String phoneNumber;
    private String pincode;
}
