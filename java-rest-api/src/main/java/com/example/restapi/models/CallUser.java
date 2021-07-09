package com.example.restapi.models;

public class CallUser extends User {

    public void notifyUser(String alert){
        System.out.println("Called :"+alert);
    }
}
