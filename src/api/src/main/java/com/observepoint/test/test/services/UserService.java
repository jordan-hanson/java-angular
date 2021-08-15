package com.observepoint.test.test.services;

import com.observepoint.test.test.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long userId);

    User findUserByUserName(String userName);

    User save(User newuser);


    User update(User updateUser, long userId);


    void delete(long userId);
}
