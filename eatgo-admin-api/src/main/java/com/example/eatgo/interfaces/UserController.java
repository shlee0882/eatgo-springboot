package com.example.eatgo.interfaces;

import com.example.eatgo.application.UserService;
import com.example.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 1. User list
    // 2. User create -> 회원가입
    // 3. User update
    // 4. User delete -> level: 0 => 아무것도 못함.
    // (1: customer, 2: restaurant owner, 3: admin)
    @GetMapping("/users")
    public List<User> list(){
        List<User> users = userService.getUsers();
        return users;
    }

}
