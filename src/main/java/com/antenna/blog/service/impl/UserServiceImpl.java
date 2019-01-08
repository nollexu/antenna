package com.antenna.blog.service.impl;

import com.antenna.blog.entity.User;
import com.antenna.blog.mapper.UserMapper;
import com.antenna.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<User> getUser(String username, String password) {
        User user = userMapper.getUser(username,password);
        return Optional.ofNullable(user);
    }
}
