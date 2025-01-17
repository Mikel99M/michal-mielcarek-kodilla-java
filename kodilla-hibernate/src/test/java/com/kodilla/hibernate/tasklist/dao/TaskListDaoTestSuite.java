package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Cars", "my vehicles");

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        Optional<TaskList> taskListOptional = taskListDao.findById(id);
        assertTrue(taskListOptional.isPresent());

        String result = taskList.getListName();
        assertEquals(result, "Cars");
        assertNotEquals(result, "bla bla");

        //Cleanup
        taskListDao.deleteById(id);

    }
}
