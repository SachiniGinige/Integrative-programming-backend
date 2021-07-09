package com.example.restapi.controllers;

import com.example.restapi.models.Alert;
import com.example.restapi.services.AlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
//@CrossOrigin(origins = "http://localhost:3000/")
@CrossOrigin(origins = "*")

public class AlertController {


    private  final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public ResponseEntity<List<Alert>> getAllSensors(){
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Alert>> getAlertBySensorId(@PathVariable String id){
        return ResponseEntity.ok(alertService.getAlertBySensorId(id));
    }

    @PostMapping("/add")
    public ResponseEntity addAlert(@RequestBody Alert alert){
        alertService.addAlert(alert);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}