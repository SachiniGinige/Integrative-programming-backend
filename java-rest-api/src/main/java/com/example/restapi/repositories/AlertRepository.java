package com.example.restapi.repositories;


import com.example.restapi.models.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

    @Repository
    public interface AlertRepository extends MongoRepository<Alert, String> {
        @Query("{'sensor_id':?0}")
        Optional<List<Alert>> findAllBySensor_id(String sensor_id);
    }


