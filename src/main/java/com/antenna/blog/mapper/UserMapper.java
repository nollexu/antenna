package com.antenna.blog.mapper;

import com.antenna.blog.entity.User;

public interface UserMapper {

    User getUser(String username, String password);

}
