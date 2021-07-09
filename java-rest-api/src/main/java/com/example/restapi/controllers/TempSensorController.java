package com.example.restapi.controllers;

import com.example.restapi.models.TempSensor;
import com.example.restapi.services.TempSensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tempreadings")
//@CrossOrigin(origins = "http://localhost:3000/")
@CrossOrigin(origins = "*")
public class TempSensorController {

    private  final TempSensorService tempSensorService;

    public TempSensorController(TempSensorService tempSensorService) {
        this.tempSensorService = tempSensorService;
    }

    @GetMapping
    public ResponseEntity<List<TempSensor>> getAllSensors(){
        return ResponseEntity.ok(tempSensorService.getAllSensors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TempSensor>> getSensorsBySensorId(@PathVariable String id){
        return ResponseEntity.ok(tempSensorService.getSensorsBySensorId(id));
    }

    @PostMapping("/add")
    public ResponseEntity addSensor(@RequestBody TempSensor tempSensor){
        tempSensorService.addSensor(tempSensor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
