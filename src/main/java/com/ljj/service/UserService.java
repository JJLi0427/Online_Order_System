package com.ljj.service;

import com.ljj.pojo.User;
import java.util.List;

public interface UserService {
    List<User> list();

    User phonegetUser(long phone);

    int updateUser(User user);

    int addUser(User user);
}