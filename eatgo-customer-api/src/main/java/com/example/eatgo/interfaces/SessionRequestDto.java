package com.example.eatgo.interfaces;

import lombok.Builder;
import lombok.Data;

@Data
public class SessionRequestDto {
    private String email;
    private String password;
}
