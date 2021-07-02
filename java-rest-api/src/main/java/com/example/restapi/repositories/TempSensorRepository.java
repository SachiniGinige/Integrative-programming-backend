package com.example.restapi.repositories;

import com.example.restapi.models.TempSensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TempSensorRepository extends MongoRepository<TempSensor, String> {
    @Query("{'sensor_id':?0}")
    Optional<List<TempSensor>> findAllBySensor_id(String sensor_id);
}
