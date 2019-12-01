package com.example.demo.sevice.impl;

import com.example.demo.model.Article;
import com.example.demo.model.Color;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<List<User>> findAllUserOlderAge(int age) {
        return Optional.ofNullable(userRepository.findByAgeGreaterThan(age));
    }

    @Override
    public Optional<List<User>> findAllUserChoseColor(Color color) {
        List<User> userList = userRepository.findAll();
        List<User> responseUserList = new ArrayList<>();

        for (User user: userList) {
           List<Article> articleList = user.getArticleList();

           for (Article article: articleList){
               if (article.getColor().equals(color)){
                   responseUserList.add(user);
                   break;
               }
           }
        }

        return Optional.ofNullable(responseUserList);
    }

    @Override
    public Optional<List<User>> findAllUserOlderArticles() {
        List<User> userList = userRepository.findAll();
        List<User> responseUserList = new ArrayList<>();

        for (User user: userList) {
            if (user.getArticleList().stream().count() > 3){
                responseUserList.add(user);
            }
        }
        return Optional.ofNullable(responseUserList);
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }
}
