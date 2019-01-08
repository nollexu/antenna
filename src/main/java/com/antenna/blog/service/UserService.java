package com.antenna.blog.service;

import com.antenna.blog.entity.User;

import java.util.Optional;


public interface UserService {
    /*获取一个可空的user对象*/
    public Optional<User> getUser(String username, String password);

}
