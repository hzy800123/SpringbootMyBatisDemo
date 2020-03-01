package com.springbootWebDemo.service;

import com.springbootWebDemo.dao.UserMapper;
import com.springbootWebDemo.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    public UserMapper userMapper;

    @BeforeEach
    void setUp() {
        System.out.println("--- Before Test Start ! ---");
    }

    @AfterEach
    void tearDown() {
        System.out.println("--- After Test Complete ! ---");
    }

    @Test
    public void findUserByUsername() {
        System.out.println("-------------");
        System.out.println("Unit Test for 'findUserByUsername() !");
        String userName = "Kate";
        List<User> userList = userMapper.findUserByUsername(userName);
        userList.forEach(System.out::println);
    }

    @Test
    public void listUser() {
        List<User> userList = userMapper.listUser();
        System.out.println("-------------");
        System.out.println("Unit Test for listUser()");
        userList.forEach(System.out::println);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUser_name("Mike");
        user.setPass_word("123456");
        user.setAge("30");
        user.setReg_time(new Timestamp(System.currentTimeMillis()));

        int insertResultCount = userMapper.insertUser(user);
        System.out.println("Insert Record Successful ! Insert Result Count = " + insertResultCount);
    }

    @Test
    public void delete() {
        int deleteId = 10;
        int deleteResultCount = userMapper.delete(deleteId);
        if (deleteResultCount == 1) {
            System.out.println("Delete Record Successful ! Delete Result Count = " + deleteResultCount);
        } else {
            System.out.println("Delete Record Failed ! Delete Result Count = " + deleteResultCount);
        }
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(11);
        user.setUser_name("Mike");
        user.setPass_word("123456");
        user.setAge("31");
        user.setReg_time(new Timestamp(System.currentTimeMillis()));

        int updateResultCount = userMapper.update(user);
        System.out.println("Update Record Successful ! Update Result Count = " + updateResultCount);
    }
}