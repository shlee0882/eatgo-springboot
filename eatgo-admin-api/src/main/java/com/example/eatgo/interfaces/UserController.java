package com.example.eatgo.interfaces;

import com.example.eatgo.application.UserService;
import com.example.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(){
        List<User> users = userService.getUsers();
        return users;
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(
            @RequestBody User resource
    ) throws URISyntaxException {
        // create
        String email = resource.getEmail();
        String name = resource.getName();

        User user = userService.addUser(email, name);
        String url = "/users/1" + user.getId();

        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deactiveUser(id);
        return "{}";
    }

    @PatchMapping("/users/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestBody User resource
    ){
        String email = resource.getEmail();
        String name = resource.getName();
        Long level = resource.getLevel();

        userService.updateUser(id, email, name, level);
        return "{}";
    }


}
