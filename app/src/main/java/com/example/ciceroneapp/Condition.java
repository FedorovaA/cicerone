package com.example.ciceroneapp;

import java.util.ArrayList;
import java.util.List;

public class Condition {

    public static List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"Pol"));
        userList.add(new User(2, "Games"));
        userList.add(new User(3, "Sam"));
        return userList;
    }
}
