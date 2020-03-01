package com.springbootWebDemo.controller;

import com.springbootWebDemo.domain.User;
import com.springbootWebDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user", method={ RequestMethod.GET, RequestMethod.POST} )
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> listUser() {
        return userService.listUser();
    }

    @RequestMapping(value="/listbyusername", method=RequestMethod.GET)
    @ResponseBody
    public List<User> listUserByUsername(String userName) {
        return userService.findUserByUsername(userName);
    }

    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String delete(int id) {
        int result = userService.delete(id);
        if (result == 1) {
            return "Delete Successful ! Delete Count = " + result;
        } else {
            return "Delete Failed";
        }
    }

    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String insert(User user) {
        int result = userService.insertUser(user);
        if (result == 1) {
            return "Insert Successful ! Insert Count = " + result;
        } else {
            return "Insert Failed";
        }
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(User user) {
        int result = userService.update(user);
        if (result == 1) {
            return "Update Successful ! Update Count = " + result;
        } else {
            return "Update Failed";
        }
    }
}
