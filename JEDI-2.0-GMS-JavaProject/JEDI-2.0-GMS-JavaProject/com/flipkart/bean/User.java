package com.flipkart.bean;

import lombok.Data;

@Data
public class User {

    private int userID;
    private String userName;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

    public User(String userName, String email, String password, Role role) {
//        this.userID = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
