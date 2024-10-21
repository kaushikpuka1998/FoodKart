package com.example.foodkart.SERVICES;

import com.example.foodkart.ENTITY.Order;
import com.example.foodkart.ENTITY.Restaurent;
import com.example.foodkart.ENTITY.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    private Map<String, List<Order>> orderHistory = new HashMap<>();
    private Random random = new Random();

    public void placeOrder(String currentUserId, Map<String, Restaurent> restaurents, String restaurentName, int quantity) {
        Restaurent restaurent = restaurents.get(restaurentName);
        if (restaurent != null && restaurent.getQuantity() >= quantity) {
            restaurent.setQuantity(restaurent.getQuantity() - quantity);
            int randomNumber = random.nextInt(9) + 1;
            Order order = new Order(String.valueOf(randomNumber), restaurentName, restaurent.getFoodItemName(), quantity);
            orderHistory.computeIfAbsent(currentUserId, k -> new ArrayList<>()).add(order);
        }
    }

    public List<Order> getOrderHistory(String phoneNumber) {
        return orderHistory.getOrDefault(phoneNumber, Collections.emptyList());
    }
}
