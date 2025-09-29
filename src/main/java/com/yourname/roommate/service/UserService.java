package com.yourname.roommate.service;

import com.yourname.roommate.entity.User;

public interface UserService {

    User registerUser(User user);
    User loginUser(String email , String password);
}
