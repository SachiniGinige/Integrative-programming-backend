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
public class TempSensorService {

    private  final TempSensorRepository tempSensorRepository;
//    private TempSensor newtempSensor;
    private UserService userService;
    private AlertService alertService;

    @Autowired
    public TempSensorService(TempSensorRepository tempSensorRepository, UserRepository userRepository, CustomRepository customRepository,AlertRepository alertRepository ) {
        this.tempSensorRepository = tempSensorRepository;
        this.userService = new UserService(userRepository, customRepository);
        this.alertService=new AlertService(alertRepository);
//        this.newtempSensor = new TempSensor();
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
        if(tempSensor.getData_value()>30.0) {
            String alertmsg="Temperature has exceeded the threshold value!\nSensor ID: "+tempSensor.getSensor_id()
                    +"\nDate/Time: "+tempSensor.getDate()+"\nCurrent Reading: "+tempSensor.getData_value()+"Celsius";
            Alert alert=new Alert(tempSensor.getSensor_id(),tempSensor.getData_value(),tempSensor.getDate(),alertmsg);
            alertService.addAlert(alert);
            notifyusers(alertmsg);

        }
        System.out.println("Successfully added current reading of Sensor ID: "+tempSensor.getSensor_id());
    }

    public void notifyusers(String alert){
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if(!user.getContactInfo().isEmpty()){
                if(user.getUserType().equals("Email")){
                    EmailUser emailUser = new EmailUser();
                    emailUser.setContactInfo(user.getContactInfo());
                    emailUser.notifyUser(alert);
                }else if(user.getUserType().equals("SMS")){
                    SMSUser smsUser = new SMSUser();
                    smsUser.setContactInfo(user.getContactInfo());
                    smsUser.notifyUser(alert);
                }else if(user.getUserType().equals("Call")){
                    CallUser callUser = new CallUser();
                    callUser.setContactInfo(user.getContactInfo());
                    callUser.notifyUser(alert);
                }
            }
        }
    }
}
