package com.example.demo.controller;

import com.example.demo.model.Color;
import com.example.demo.model.User;
import com.example.demo.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/age/{age}")
    public ResponseEntity<Optional> getUser(@PathVariable Integer age) {
        Optional<List<User>> users = userService.findAllUserOlderAge(age);

        if (users.isPresent()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/color/{color}")
    public ResponseEntity<Optional> getUser(@PathVariable Color color) {
        Optional<List<User>> users = userService.findAllUserChoseColor(color);

        if (users.isPresent()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/articles/")
    public ResponseEntity<Optional> listAllUserOlderYear() {
        Optional<List<User>> users = userService.findAllUserOlderArticles();

        if (users.isPresent()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
