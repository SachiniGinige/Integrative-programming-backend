package com.example.restapi.models;

import com.sun.mail.util.MailSSLSocketFactory;
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
    String email="";
    @Field
    private
    String mobile_no="";

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public void notifyUser(String alert){
        sendEmail(alert);
    }

    public void sendEmail(String msg) {
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);


        String recipient = getEmail();

        // email ID of  Sender.
        String sender = "teamcodersinc@gmail.com";
        String password = "codersInc001";

        // using host as localhost
        String host = "smtp.gmail.com";
        String port = "587";

        // Getting system properties
        Properties properties = System.getProperties();

        // Setting up mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        properties.put("mail.imap.ssl.trust", "*");
        properties.put("mail.imap.ssl.socketFactory", sf);
        // creating session object to get properties
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });

        session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        session.getProperties().put("mail.smtp.starttls.enable", "true");

        try {
            // MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject("Temperature Alert");

            // set body of the email.
            message.setText(msg);

            // Send email.
            Transport.send(message);
            System.out.println("Mail sent successfully");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
