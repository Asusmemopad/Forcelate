package com.example.demo.sevice.impl;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.sevice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }
}
