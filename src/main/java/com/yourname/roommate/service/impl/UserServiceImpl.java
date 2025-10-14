package com.yourname.roommate.service.impl;

import com.yourname.roommate.entity.User;
import com.yourname.roommate.repository.UserRepository;
import com.yourname.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(User.Role.USER);

        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        User existingUser = userRepository.findByEmail(email);

        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(password, existingUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return existingUser;
    }
}
