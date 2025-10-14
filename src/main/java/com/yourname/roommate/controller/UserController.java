package com.yourname.roommate.controller;

import com.yourname.roommate.entity.User;
import com.yourname.roommate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // Signup API
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request){
        User user = userService.loginUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(user);
    }

    // DTO for login request
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
