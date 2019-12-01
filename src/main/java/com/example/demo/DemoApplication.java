package com.example.demo;

import com.example.demo.model.Article;
import com.example.demo.model.Color;
import com.example.demo.model.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {

            //Create users
            User user0 = User.builder().name("John_1").age(22).build();
            User user1 = User.builder().name("John_2").age(24).build();
            User user2 = User.builder().name("John_3").age(27).build();
            User user3 = User.builder().name("John_4").age(31).build();
            User user4 = User.builder().name("John_5").age(36).build();

            //Create articles
            Article article0 = Article.builder().
                    color(Color.BLACK).text("text0").user(user0).build();
            Article article1 = Article.builder().
                    color(Color.WHITE).text("text1").user(user1).build();
            Article article2 = Article.builder().
                    color(Color.GREEN).text("text2").user(user1).build();
            Article article3 = Article.builder().
                    color(Color.GRAY).text("text3").user(user2).build();
            Article article4 = Article.builder().
                    color(Color.RED).text("text4").user(user3).build();
            Article article5 = Article.builder().
                    color(Color.BLACK).text("text5").user(user4).build();
            Article article6 = Article.builder().
                    color(Color.WHITE).text("text6").user(user4).build();
            Article article7 = Article.builder().
                    color(Color.GREEN).text("text7").user(user4).build();
            Article article8 = Article.builder().
                    color(Color.GRAY).text("text8").user(user4).build();

            //Save users
            Stream.of(user0, user1, user2, user3, user4)
                    .forEach(n -> userRepository.save(n));

            //Save articles
            Stream.of(article0, article1, article2, article3,
                    article4, article5, article6, article7, article8)
                    .forEach(n -> articleRepository.save(n));
        };
    }
}
