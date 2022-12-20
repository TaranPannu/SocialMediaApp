package com.example.fall_2022;

public class example_item {
String I;
String u;
String e;
String UID;
    public example_item(String img,String user,String email,String uid){
     I=img;
     u=user;
     e=email;
UID=uid;
    }

    public String getUID() {
        return UID;
    }

    public String getEmail() {
        return e;
    }

    public String getImage() {
        return I;
    }

    public String getUser() {
        return u;
    }
}
