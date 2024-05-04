package com.ljj.service.impl;

import com.ljj.service.UserService;
import com.ljj.mapper.UserMapper;
import com.ljj.pojo.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private UserMapper UserMapper;

    public List<User> list(){
        List<User> list = UserMapper.listUser();
        return list;
    }

    public User phonegetUser(long phone){
        User user = UserMapper.phonegetUser(phone);
        return user;
    }

    public int updateUser(User user){
        int i = UserMapper.updateUser(user);
        return i;
    }

    public int addUser(User user){
        int i = UserMapper.addUser(user);
        return i;
    }
}