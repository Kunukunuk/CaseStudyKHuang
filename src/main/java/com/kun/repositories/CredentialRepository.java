package com.kun.repositories;

import com.kun.models.Credential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, String> {

    Credential findByUsername(String username);

}
