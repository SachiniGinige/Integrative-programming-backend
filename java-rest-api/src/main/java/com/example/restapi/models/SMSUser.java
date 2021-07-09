package com.example.restapi.models;

public class SMSUser extends User {

    public void notifyUser(String alert){
        System.out.println(alert);
    }
}
