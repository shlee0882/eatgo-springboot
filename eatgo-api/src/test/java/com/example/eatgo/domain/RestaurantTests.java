package com.example.eatgo.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTests {
    @Test
    public void creaction(){
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        // 단정문 ~는 ~여야 한다.
        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information(){
        Restaurant restaurant= new Restaurant(1004L,"Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}