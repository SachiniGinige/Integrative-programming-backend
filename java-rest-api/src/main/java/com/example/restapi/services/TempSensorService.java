package com.example.restapi.services;

import com.example.restapi.models.TempSensor;
import com.example.restapi.models.User;
import com.example.restapi.repositories.TempSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempSensorService {

    private  final TempSensorRepository tempSensorRepository;

    @Autowired
    public TempSensorService(TempSensorRepository tempSensorRepository) {
        this.tempSensorRepository = tempSensorRepository;
    }

    public List<TempSensor> getAllSensors(){
        return tempSensorRepository.findAll();
    }

    public List<TempSensor> getSensorsBySensorId(String id){
        return tempSensorRepository.findAllBySensor_id(id)
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot find sensors by Sensor ID: %s",id)
                ));
    }

    public void addSensor(TempSensor tempSensor){
        tempSensorRepository.insert(tempSensor);
        System.out.println("Successfully added current reading of Sensor ID: "+tempSensor.getSensor_id());
    }
}
