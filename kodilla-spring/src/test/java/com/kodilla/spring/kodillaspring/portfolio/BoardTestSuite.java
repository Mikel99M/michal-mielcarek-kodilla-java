package com.kodilla.spring.kodillaspring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        //When
        String textOne = "write tesis";
        String textTwo = "become a millioner";
        board.getToDoList().addTask(textOne);
        board.getToDoList().addTask(textTwo);

        String textThree = "write a memoire";
        board.getInProgressList().addTask(textThree);

        String textFour = "make a sandwich";
        board.getDoneList().addTask(textFour);

        //Then
        assertTrue(board.getToDoList().getTasks().contains(textOne));
        assertTrue(board.getToDoList().getTasks().contains(textTwo));
        assertFalse(board.getToDoList().getTasks().contains(textThree));
        assertEquals(2, board.getToDoList().getTasks().size());

        assertTrue(board.getInProgressList().getTasks().contains(textThree));
        assertEquals(1, board.getInProgressList().getTasks().size());

        assertTrue(board.getDoneList().getTasks().contains(textFour));
        assertEquals(1, board.getDoneList().getTasks().size());

        board.getDoneList().addTask(textThree);

        assertTrue(board.getDoneList().getTasks().contains(textThree));
        assertEquals(2, board.getDoneList().getTasks().size());
    }
}
