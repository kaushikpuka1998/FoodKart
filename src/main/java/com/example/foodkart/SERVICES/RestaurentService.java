package com.example.foodkart.SERVICES;

import com.example.foodkart.ENTITY.Restaurent;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Service
public class RestaurentService {
    private Map<String, Restaurent> Restaurents = new HashMap<>();

    public Restaurent registerRestaurent(Restaurent Restaurent) {
        if (Restaurents.containsKey(Restaurent.getName())) {
            throw new RuntimeException("Restaurent already exists");
        }
        Restaurents.put(Restaurent.getName(), Restaurent);
        return Restaurent;
    }

    public Restaurent getRestaurentByName(String RestaurentName) {
        return Restaurents.get(RestaurentName);
    }

    public void updateQuantity(String RestaurentName, int quantity) {
        Restaurent Restaurent = Restaurents.get(RestaurentName);
        if (Restaurent != null) {
            Restaurent.setQuantity(Restaurent.getQuantity() + quantity);
        }
    }

    public void rateRestaurent(String RestaurentName, int rating, String comment) {
        Restaurent Restaurent = Restaurents.get(RestaurentName);
        if (Restaurent != null) {
            double totalRating = Restaurent.getRating() * Restaurent.getRatingCount();
            Restaurent.setRatingCount(Restaurent.getRatingCount() + 1);
            Restaurent.setRating((totalRating + rating) / Restaurent.getRatingCount());
        }
    }

    public List<Restaurent> showRestaurent(String sortBy, String userPincode) {
        List<Restaurent> serviceableRestaurents = new ArrayList<>();
        for (Restaurent Restaurent : Restaurents.values()) {
            if (Restaurent.getServiceablePincode().contains(userPincode)) {
                serviceableRestaurents.add(Restaurent);
            }
        }

        if ("rating".equals(sortBy)) {
            serviceableRestaurents.sort((r1, r2) -> Double.compare(r2.getRating(), r1.getRating()));
        } else if ("price".equals(sortBy)) {
            serviceableRestaurents.sort((r1, r2) -> Double.compare(r1.getPrice(), r2.getPrice()));
        }

        return serviceableRestaurents;
    }
}