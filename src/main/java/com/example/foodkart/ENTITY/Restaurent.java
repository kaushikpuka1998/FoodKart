package com.example.foodkart.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Restaurent {
    private String name;
    private List<String> serviceablePincode;
    private String foodItemName;
    private int quantity;
    private double price;
    private double rating;
    private int ratingCount;
}
