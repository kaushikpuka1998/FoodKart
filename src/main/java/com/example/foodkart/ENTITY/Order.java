package com.example.foodkart.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    private String orderId;
    private String restaurentName;
    private String foodItemName;
    private int quantity;
}
