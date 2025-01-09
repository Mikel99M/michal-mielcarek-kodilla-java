package com.kodilla.spring.kodillaspring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(this.getToDoList(), this.getInProgressList(), this.getDoneList());
    }
}
