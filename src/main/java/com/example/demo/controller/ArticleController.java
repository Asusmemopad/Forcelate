package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.sevice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article){
        articleService.saveArticle(article);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }
}
