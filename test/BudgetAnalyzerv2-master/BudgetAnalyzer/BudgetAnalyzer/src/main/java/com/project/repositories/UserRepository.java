package com.project.repositories;

import com.project.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    public Iterable<User> findAll();

    public User findByUsername(String username);
}
