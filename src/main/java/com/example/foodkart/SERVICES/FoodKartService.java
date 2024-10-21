package com.example.foodkart.SERVICES;


import com.example.foodkart.ENTITY.Order;
import com.example.foodkart.ENTITY.Restaurent;
import com.example.foodkart.ENTITY.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodKartService {
    private Map<String , User> users = new HashMap<>();
    private Map<String, Restaurent> restaurents = new HashMap<>();
    private Map<String, List<Order>>orderHistory = new HashMap<>();
    private String currentUserId = null;
    Random random = new Random();

    public User registerUser(User user){
        users.put(user.getPhoneNumber(), user);
        return user;
    }

    public User loginUserUser(User user){
        if(users.containsKey(user.getPhoneNumber())){
            currentUserId = user.getPhoneNumber();
            return user;
        }

        return null;
    }

    public Restaurent registerRestaurent(Restaurent restaurent){
        if(currentUserId != null){
            if(!restaurents.containsKey(restaurent.getName())) {
                restaurents.put(restaurent.getName(), restaurent);
                return restaurent;
            }else{
                throw new RuntimeException("Restaurent already exists");
            }
        }
        return null;
    }

    public void updateQuantity(String restaurentName, int quantity){
        Restaurent restaurent = restaurents.get(restaurentName);
        if(restaurent != null){
            restaurent.setQuantity(restaurent.getQuantity() + quantity);
        }

    }

    public void rateRestaurent(String restaurentName, int rating,String comment){
        Restaurent restaurent = restaurents.get(restaurentName);
        if(restaurent != null){
           double totalRating = restaurent.getRating() * restaurent.getRatingCount();
           restaurent.setRatingCount(restaurent.getRatingCount() + 1);
           restaurent.setRating((totalRating + rating)/restaurent.getRatingCount());
        }
    }

    public List<Restaurent> showRestaurent(String sortBy){
        List<Restaurent> serviceableRestaurents = new ArrayList<>();
        User user = users.get(currentUserId);

        for(Restaurent restaurent : restaurents.values()){
            if(restaurent.getServiceablePincode().contains(user.getPincode())){
                serviceableRestaurents.add(restaurent);
            }
        }

        if("rating".equals(sortBy)) {
            serviceableRestaurents.sort((r1, r2) -> Double.compare(r2.getRating(), r1.getRating()));
        }
        else if("price".equals(sortBy)){
            serviceableRestaurents.sort((r1, r2) -> Double.compare(r1.getPrice(), r2.getPrice()));
        }

        return serviceableRestaurents;
    }

    public void placeOrder(String restaurentName, int quantity){
        Restaurent restaurent = restaurents.get(restaurentName);
        if(restaurent != null && restaurent.getQuantity()>=quantity){
           restaurent.setQuantity(restaurent.getQuantity() - quantity);
            int randomNumber = random.nextInt(9) + 1;
            Order order = new Order(String.valueOf(randomNumber),restaurentName,restaurent.getFoodItemName(), quantity);
            orderHistory.computeIfAbsent(currentUserId, k -> new ArrayList<>()).add(order);

        }
    }

    public List<Order> getorderHistory(){
        return orderHistory.getOrDefault(currentUserId,Collections.emptyList());
    }

}
