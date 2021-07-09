package com.example.restapi.models;

import com.example.restapi.services.UserService;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;
import java.util.Date;

@Data
@Document(collection = "tempreadings")
public class TempSensor {
    @Field
    private String sensor_id;
    @CreatedDate
    private Date date;
    @Field
    private double data_value;

    public TempSensor(String sensor_id, Date date, double data_value) {
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

    public double getData_value() {
        return data_value;
    }

    public void setData_value(double data_value) {
        this.data_value = data_value;
    }
}
