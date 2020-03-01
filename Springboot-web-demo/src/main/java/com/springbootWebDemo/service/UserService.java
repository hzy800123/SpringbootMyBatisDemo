package com.springbootWebDemo.service;

import com.springbootWebDemo.dao.UserMapper;
import com.springbootWebDemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findUserByUsername(String user_name) {
        return userMapper.findUserByUsername(user_name);
    }

    public List<User> listUser() {
        return userMapper.listUser();
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int delete(int id) {
        return userMapper.delete(id);
    }

    public int update(User user) {
        return userMapper.update(user);
    }
}
