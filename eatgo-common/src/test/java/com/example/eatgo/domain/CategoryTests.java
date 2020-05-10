package com.example.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryTests {

    @Test
    public void creation(){
        Category category = Category.builder().name("Korean Food").build();
        assertThat(category.getName(), is("Korean Food"));
    }

}