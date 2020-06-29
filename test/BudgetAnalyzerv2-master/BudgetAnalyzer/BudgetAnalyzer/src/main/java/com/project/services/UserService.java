package com.project.services;

import com.project.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByUsername(String username);

    void save(User user);
}
