package com.kodilla.spring.forum;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    String userName;

    public ForumUser() {
        userName = "John Smith";
    }

    public String getUserName() {
        return userName;
    }
}
