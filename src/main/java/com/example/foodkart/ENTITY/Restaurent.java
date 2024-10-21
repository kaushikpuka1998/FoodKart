package com.example.foodkart.ENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class Restaurent {
    private String name;
    private List<String> serviceablePincode;
    private String foodItemName;
    private int quantity;
    private double price;
    private double rating;
    private int ratingCount;

    public Restaurent(String name, List<String> serviceablePincode, String foodItemName, int quantity, double price, double rating, int ratingCount) {
        this.name = name;
        this.serviceablePincode = serviceablePincode;
        this.foodItemName = foodItemName;
        this.quantity = quantity;
        this.price = price;
        this.rating = rating;
        this.ratingCount = ratingCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getServiceablePincode() {
        return serviceablePincode;
    }

    public void setServiceablePincode(List<String> serviceablePincode) {
        this.serviceablePincode = serviceablePincode;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

}
