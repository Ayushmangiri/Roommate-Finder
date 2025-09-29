package com.yourname.roommate.service.impl;

import com.yourname.roommate.entity.User;
import com.yourname.roommate.repository.UserRepository;
import com.yourname.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {
    @Autowired

    private UserRepository userRepository;//DB m Bridge ka kaam krega

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();// passwords ko encrypt karega ....iss line se.

    @Override
    public User registerUser(User user){

        // Email Checked
        if(userRepository.findByEmail(user.getEmail()) != null){
        throw  new RuntimeException("Email already exists");

    }

//password encrypt

        user.setPassword(passwordEncoder.encode(user.getPassword()));

}
