package com.example.eatgo.interfaces;

import com.example.eatgo.domain.Restaurant;
import com.example.eatgo.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = repository.findById(id);
        return restaurant;
    }
}
