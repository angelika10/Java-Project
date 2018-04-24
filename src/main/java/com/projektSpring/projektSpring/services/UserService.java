package com.projektSpring.projektSpring.services;

import com.projektSpring.projektSpring.domain.User;
import com.projektSpring.projektSpring.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.showAllUsers();
    }
}
