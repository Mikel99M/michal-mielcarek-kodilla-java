package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }

        rs.close();
        statement.close();
        assertEquals(4, counter);

    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*)
                FROM USERS U JOIN POSTS P on U.ID = P.USER_ID
                GROUP BY USER_ID
                HAVING COUNT(*) >= 2;
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        String sqlQuery2 = """
                SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*)
                FROM USERS U JOIN POSTS P on U.ID = P.USER_ID
                GROUP BY USER_ID
                HAVING COUNT(*) >= 1;
                """;
        Statement statement2 = dbManager.getConnection().createStatement();
        ResultSet rs2 = statement2.executeQuery(sqlQuery2);

        //Then
        System.out.println("Scenario with at least two posts: ");
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }

        System.out.println("Scenario with at least one post: ");
        int counter2 = 0;
        while (rs2.next()) {
            System.out.println(rs2.getString("FIRSTNAME") + ", " +
                    rs2.getString("LASTNAME"));
            counter2++;
        }

        rs.close();
        statement.close();
        assertEquals(1, counter);
        assertEquals(3, counter2);
    }
}
