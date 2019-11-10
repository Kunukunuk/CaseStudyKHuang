package com.kun.services;

import com.kun.models.Reserve;
import com.kun.repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ReserveService")
public class ReserveService {

    @Autowired
    ReserveRepository reserveRepository;

    public void save(Reserve reserve) {
        reserveRepository.save(reserve);
    }


}
