package com.example.foodkart.CONTROLLERS;

import com.example.foodkart.ENTITY.Order;
import com.example.foodkart.ENTITY.Restaurent;
import com.example.foodkart.ENTITY.User;
import com.example.foodkart.SERVICES.FoodKartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodkart")
public class FoodKartController {
    @Autowired
    private FoodKartService foodkartService;

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody User user) {
        return ResponseEntity.ok(foodkartService.registerUser(user));
    }

    @PostMapping("/loginUser")
    public ResponseEntity loginUser(@RequestBody User user) {
        return ResponseEntity.ok(foodkartService.loginUserUser(user));
    }

    @PostMapping("/registerRestaurant")
    public ResponseEntity registerRestaurant(@RequestBody Restaurent restaurant) {
        return ResponseEntity.ok(foodkartService.registerRestaurent(restaurant));
    }

    @PostMapping("/updateQuantity")
    public void updateQuantity(@RequestParam String restaurantName, @RequestParam int quantityToAdd) {
        foodkartService.updateQuantity(restaurantName, quantityToAdd);
    }

    @PostMapping("/rateRestaurant")
    public void rateRestaurant(@RequestParam String restaurantName, @RequestParam int rating, @RequestParam(required = false) String comment) {
        foodkartService.rateRestaurent(restaurantName, rating, comment);
    }

    @GetMapping("/showRestaurant")
    public List<Restaurent> showRestaurant(@RequestParam String sortBy) {
        return foodkartService.showRestaurent(sortBy);
    }

    @PostMapping("/placeOrder")
    public void placeOrder(@RequestParam String restaurantName, @RequestParam int quantity) {
        foodkartService.placeOrder(restaurantName, quantity);
    }

    @GetMapping("/orderHistory")
    public List<Order> getOrderHistory() {
        return foodkartService.getorderHistory();
    }
}
