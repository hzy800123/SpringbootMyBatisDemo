package com.springbootWebDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@RestController
@Controller
@RequestMapping(value="/user", method={RequestMethod.GET, RequestMethod.POST})
public class UserControllerTest {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Springboot Web Hello World !";
    }

    @RequestMapping("/bye")
    @ResponseBody
    public String bye() {
        return "88";
    }

    @RequestMapping("/test")
    public String test(Map<String, String> map) {
        String strResult="Data Base Return Result";
        map.put("str", strResult);
        return "testmain";
    }

    @RequestMapping("/test2")
    public String test2(Model model) {
        String nameObject = "name result";
        model.addAttribute("name", nameObject);
        return "testmain2";
    }

}
