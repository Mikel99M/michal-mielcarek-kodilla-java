package com.kodilla.patterns.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> users = new ArrayList<>();

    public Forum() {
        users.add(new ForumUser(1, "John Malkovich", 'M', "1953-12-09", 3));
        users.add(new ForumUser(2, "Jake Paul", 'M', "2005-05-15", 12));
        users.add(new ForumUser(3, "Ethan Hawke", 'M', "2007-11-22", 5));
        users.add(new ForumUser(4, "Chris Hemsworth", 'M', "1983-08-11", 7));
        users.add(new ForumUser(5, "Robert Downey Jr.", 'M', "1965-04-04", 10));
        users.add(new ForumUser(6, "Timothee Chalamet", 'M', "2006-06-27", 6));
        users.add(new ForumUser(7, "Tom Holland", 'M', "2003-06-01", 0));
        users.add(new ForumUser(8, "Chris Evans", 'M', "1981-06-13", 4));
        users.add(new ForumUser(9, "Emma Watson", 'F', "1990-04-15", 15));
        users.add(new ForumUser(10, "Scarlett Johansson", 'F', "1984-11-22", 0));
    }


    public List<ForumUser> getList() {
        return users;
    }


}
