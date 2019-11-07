package com.kun.repositories;

import com.kun.models.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Integer> {

    Parking save(Parking parking);

    Set<Parking> findAll();

}
