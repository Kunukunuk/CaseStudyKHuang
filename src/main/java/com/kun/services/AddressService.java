package com.kun.services;

import com.kun.models.Address;
import com.kun.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AddressService")
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public void save(Address address) {
        addressRepository.save(address);
    }

    public Address getAddressById(int id) {

        return addressRepository.findById(id);

    }
}
