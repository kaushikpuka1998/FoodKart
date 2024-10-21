package com.example.foodkart.SERVICES;


import com.example.foodkart.ENTITY.Order;
import com.example.foodkart.ENTITY.Restaurent;
import com.example.foodkart.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodKartService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Restaurent> restaurents = new HashMap<>();
    private String currentUserId = null;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurentService restaurantService;

    @Autowired
    private OrderService orderService;

    public User registerUser(User user) {
        return userService.registerUser(user);
    }

    public User loginUser(User user) {
        User loggedInUser = userService.loginUser(user);
        if(loggedInUser != null) {
            currentUserId = loggedInUser.getPhoneNumber();
        }
        return loggedInUser;
    }

    public Restaurent registerRestaurent(Restaurent restaurent) {
        if(restaurents.containsKey(restaurent.getName())) {
            throw new RuntimeException("Restaurent already exists");
        }
        restaurents.put(restaurent.getName(), restaurent);
        return restaurantService.registerRestaurent(restaurent);
    }

    public void updateQuantity(String restaurentName, int quantity) {
        restaurantService.updateQuantity(restaurentName, quantity);
        // Update the local map to keep it in sync
        Restaurent updatedRestaurent = restaurantService.getRestaurentByName(restaurentName);
        restaurents.put(restaurentName, updatedRestaurent);
    }

    public void rateRestaurent(String restaurentName, int rating, String comment) {
        restaurantService.rateRestaurent(restaurentName, rating, comment);
        // Update the local map to keep it in sync
        Restaurent updatedRestaurent = restaurantService.getRestaurentByName(restaurentName);
        restaurents.put(restaurentName, updatedRestaurent);
    }

    public List<Restaurent> showRestaurent(String sortBy) {
        return restaurantService.showRestaurent(sortBy, users.get(currentUserId).getPincode());
    }

    public void placeOrder(String restaurentName, int quantity) {
        orderService.placeOrder(currentUserId, restaurents, restaurentName, quantity);
    }

    public List<Order> getOrderHistory(String phoneNumber) {
        return orderService.getOrderHistory(phoneNumber);
    }
}
