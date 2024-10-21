package com.example.foodkart.SERVICES;

import com.example.foodkart.ENTITY.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> users = new HashMap<>();
    private String currentUserId;

    public User registerUser(User user) {
        users.put(user.getPhoneNumber(), user);
        return user;
    }

    public User loginUser(User user) {
        if(users.containsKey(user.getPhoneNumber())) {
            currentUserId = user.getPhoneNumber();
            return users.get(currentUserId);
        }
        return null;
    }

    public User getCurrentUser() {
        return users.get(currentUserId);
    }
}
