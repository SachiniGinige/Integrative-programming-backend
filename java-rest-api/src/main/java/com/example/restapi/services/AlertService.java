package com.example.restapi.services;

import com.example.restapi.models.*;
import com.example.restapi.repositories.AlertRepository;
import com.example.restapi.repositories.CustomRepository;
import com.example.restapi.repositories.TempSensorRepository;
import com.example.restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private  final AlertRepository alertRepository;
    //    private TempSensor newtempSensor;



    @Autowired
    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;

    }

    public List<Alert> getAllAlerts(){
        return alertRepository.findAll();
    }

    public List<Alert> getAlertBySensorId(String id){
        return alertRepository.findAllBySensor_id(id)
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find alerts by Sensor ID: %s",id)
                ));
    }

    public void addAlert(Alert alert){
        alertRepository.insert(alert);

    }



}