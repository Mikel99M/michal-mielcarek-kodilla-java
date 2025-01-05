package com.kodilla.patterns.spring.forum;

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
