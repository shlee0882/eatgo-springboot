package com.example.eatgo.application;

import com.example.eatgo.domain.User;
import com.example.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String email, String name) {
        User user = User.builder().email(email).name(name).level(1L).build();
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, String email, String name, Long level) {
        User user = userRepository.findById(id).orElse(null);

        user.setName(name);
        user.setEmail(email);
        user.setLevel(level);

        return user;
    }

    public User deactiveUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.deactivate();
        return user;
    }
}
