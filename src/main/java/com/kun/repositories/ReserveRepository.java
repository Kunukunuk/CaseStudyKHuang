package com.kun.repositories;

import com.kun.models.Reserve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends CrudRepository<Reserve, Integer> {

    Reserve save(Reserve reserve);
}
