package com.yourname.roommate.service;

import com.yourname.roommate.entity.User;

public interface UserService {

    User registration(User user);
    User loginUser(String email , String password);
}
