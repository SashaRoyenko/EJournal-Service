package com.robosh.ejournal.controller;

import com.robosh.ejournal.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/users/user/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        if (id < 10) {
            return new ResponseEntity<>(getUser(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = getUserById(i + 1L);
            users.add(user);
        }
        return users;
    }

    private User getUserById(long id) {
        return User.builder()
                .id(id)
                .firstName("Oleksandr")
                .lastName("Roienko")
                .age(19)
                .birthDate(LocalDate.of(2000, 4, 24))
                .build();
    }
}
