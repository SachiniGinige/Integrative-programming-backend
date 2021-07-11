package com.example.restapi.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Date;

@Data
@Document(collection = "alerts")
public class Alert {

    @Id
    private String alert_id;
    @Field
    private String sensor_id;
    @Field
    private double data_value;
    @CreatedDate
    private Date date;
    @Field
    private String message;

    public Alert(String sensor_id, double data_value, Date date, String message) {
        this.sensor_id = sensor_id;
        this.data_value=data_value;
        this.date = date;
        this.message = message;
    }

    public String getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
