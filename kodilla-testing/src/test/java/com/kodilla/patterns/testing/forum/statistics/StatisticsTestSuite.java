package com.kodilla.patterns.testing.forum.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {
    private List<String> generateListOfUsers(int userQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < userQuantity; i++) {
            resultList.add("Nick " + i);  // Add usernames like "Nick 0", "Nick 1", ...
        }
        return resultList;
    }

    @Mock
    private Statistics statisticsMock;

    @Test
    @DisplayName("Testing when num of posts = 0")
    public void FirstTest() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int result = forumStats.getPostsCount();
        //Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Testing when num of posts = 1000")
    public void SecondTest() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int result = forumStats.getPostsCount();
        //Then
        assertEquals(1000, result);
    }

    @Test
    @DisplayName("Testing when num of comments = 0")
    public void ThirdTest() {
        //Given
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int result = forumStats.getCommentsCount();
        //Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Testing when num of comments < num of posts")
    public void FourthTest() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(0);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int numOfPosts = forumStats.getPostsCount();
        int numOfComments = forumStats.getCommentsCount();
        //Then
        assertTrue(numOfPosts > numOfComments);
    }

    @Test
    @DisplayName("Testing when num of comments > num of posts")
    public void FifthTest() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(150);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int numOfPosts = forumStats.getPostsCount();
        int numOfComments = forumStats.getCommentsCount();
        //Then
        assertTrue(numOfPosts < numOfComments);
    }

    @Test
    @DisplayName("Testing when num of users = 0")
    public void SixthTest() {
        //Given
        List<String> resultListOfUsers = generateListOfUsers(0);
        when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int result = forumStats.getUsersCount();
        //Then
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Testing when num of users = 1000")
    public void SeventhTest() {
        //Given
        List<String> resultListOfUsers = generateListOfUsers(1000);
        when(statisticsMock.usersNames()).thenReturn(resultListOfUsers);

        StatisticCalculation forumStats = new StatisticCalculation();

        //When
        forumStats.calculateAdvStatistics(statisticsMock);
        int result = forumStats.getUsersCount();

        //Then
        assertEquals(1000, result);
    }

}
