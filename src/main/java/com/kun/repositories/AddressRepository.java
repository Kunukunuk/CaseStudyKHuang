package com.kun.repositories;

import com.kun.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

    Address save(Address address);

    Address findById(int id);

    Set<Address> findAddressBy();
}
