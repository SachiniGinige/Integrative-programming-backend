package com.example.restapi.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "tempsensors")
public class TempSensor {
    @Field
    private String sensor_id;
    @Field
    private Date date;
    @Field
    private String data_value;


    public TempSensor(String sensor_id, Date date, String data_value) {
        this.sensor_id = sensor_id;
        this.date = date;
        this.data_value = data_value;
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

    public String getData_value() {
        return data_value;
    }

    public void setData_value(String data_value) {
        this.data_value = data_value;
    }
}
