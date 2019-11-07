package com.kun.repositories;

import com.kun.models.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends CrudRepository<Parking, Integer> {
    Parking findBy(int id);
}
