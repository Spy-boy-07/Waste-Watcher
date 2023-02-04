package com.example.wastewatcher;

public class User {
    public String username;
    public String name;
    public String email;
    public String userid;
    public String num;
    public String city;
    public String area;

    public User() {
    }

    public User( String userid, String username, String name, String email, String num, String city, String area) {
        this.userid = userid;
        this.username = username;
        this.name = name;
        this.email = email;
        this.num = num;
        this.city = city;
        this.area = area;
    }
}
