package com.kun.repositories;

import com.kun.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User save(User user);

    User findBy(int id);

}
