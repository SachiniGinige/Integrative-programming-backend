package com.example.restapi.models;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Document(collection = "users")
public class User {

    @Field
    private
    String user_id="";
    @Field
    private
    String name="";
    @Field
    private
    String type="";
    @Field
    private
    String contact_info="";

    @Field
    private
    String password="";

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return type;
    }

    public void setUserType(String type) {
        this.type = type;
    }

    public String getContactInfo() {
        return contact_info;
    }

    public void setContactInfo(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void notifyUser(String alert){}

}
