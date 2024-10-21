package com.example.foodkart.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;

public class User {
    private String name;
    private String gender;
    private String phoneNumber;
    private String pincode;

    public User(String name, String gender, String phoneNumber, String pincode) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
