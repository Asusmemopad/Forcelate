package com.example.demo.sevice;

import com.example.demo.model.Color;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<List<User>> findAllUserOlderAge(int age);
    Optional<List<User>> findAllUserChoseColor(Color color);
    Optional<List<User>> findAllUserOlderArticles();
    User saveUser(User user);
}
