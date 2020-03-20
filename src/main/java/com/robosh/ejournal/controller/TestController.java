package com.robosh.ejournal.controller;

import com.robosh.ejournal.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/users/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        if (id > 10) {
            return getUser();
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        User user = getUser();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(user);
        }
        return users;
    }

    private User getUser() {
        return User.builder()
                .firstName("Oleksandr")
                .lastName("Roienko")
                .age(19)
                .birthDate(LocalDate.of(2000, 4, 24))
                .build();
    }
}
