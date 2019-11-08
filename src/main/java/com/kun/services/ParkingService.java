package com.kun.services;

import com.kun.models.Parking;
import com.kun.repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("ParkingService")
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;

    public void save(Parking parking) {
        parkingRepository.save(parking);
    }

    public Set<Parking> getAllParkings() {
        Set<Parking> parkings = new HashSet<Parking>();
        parkingRepository.findAll().forEach(parkings::add);
        return parkings;
    }

}
