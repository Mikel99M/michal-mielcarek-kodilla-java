package com.kodilla.patterns.testing.forum.statistics;

import java.util.HashMap;
import java.util.Map;

public class StatisticCalculation {
    private int usersCount = 0;
    private int postsCount = 0;
    private int commentsCount = 0;
    private double postsPerUser = 0.0;
    private double commentsPerUser = 0.0;
    private double commentsPerPost = 0.0;

    private Map<String, Object> allStats = new HashMap<>();
    private String allStatsText = "";

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        if (usersCount > 0) {
            postsPerUser = (double) postsCount / usersCount;
        } else {
            postsPerUser = 0.0;
        }
        if (usersCount > 0) {
            commentsPerUser = (double) commentsCount / usersCount;
        } else {
            commentsPerUser = 0.0;
        }

        if (postsCount > 0) {
            commentsPerPost = (double) commentsCount / postsCount;
        } else {
            commentsPerPost = 0.0;
        }

        allStats.put("Number of users", usersCount);
        allStats.put("Number of posts", postsCount);
        allStats.put("Number of comments", commentsCount);
        allStats.put("Number of posts per user", postsPerUser);
        allStats.put("Number of comments per user", commentsPerUser);
        allStats.put("Number of comments per post", commentsPerPost);
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    public String showStatistics() {
        allStatsText = "";
        for (Map.Entry<String, Object> entry : allStats.entrySet()) {
            allStatsText += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return allStatsText;
    }
}
