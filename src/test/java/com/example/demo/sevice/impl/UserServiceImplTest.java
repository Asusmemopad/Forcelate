package com.example.demo.sevice.impl;

import com.example.demo.model.Article;
import com.example.demo.model.Color;
import com.example.demo.model.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.sevice.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ArticleRepository articleRepository;

    @Test
    public void saveUser() {
        User user = User.builder()
                .name("Andrey").age(40).build();
        Article article = Article.builder().
                user(user).color(Color.WHITE).build();
        articleRepository.save(article);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        assertThat(userService.saveUser(user)).isEqualTo(user);
    }
}