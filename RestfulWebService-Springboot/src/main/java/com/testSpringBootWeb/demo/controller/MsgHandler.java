package com.testSpringBootWeb.demo.controller;

import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@Controller
public class MsgHandler {
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(method = RequestMethod.GET, value = "/request/{requestId}")
    ResponseEntity messageHandler(@PathVariable("requestId") String requestId) {
        System.out.println(" ------ Start to process method messageHandler() ------ ");
        System.out.println("requestId: " + requestId);

        MsgProcessor msgProcessor = (MsgProcessor)applicationContext.getBean("Msg" + requestId + "Processor");
        String resultString = msgProcessor.process(requestId);

        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity(
                        resultString +
                              " The response is fine here ! ",
                              HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/num")
    ResponseEntity messageNumHandler(@RequestParam(name = "num") int num) {
        System.out.println(" ------ Start to process method messageNumHandler() ------ ");
        System.out.println(" Input num: " + num);

        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity("The input Num " + num + " is processed here.", HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping(value = "/*")
    ResponseEntity otherMessageHandler() {
        System.out.println(" ------ Start to process method otherMessageHandler() ------ ");

        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity("Other message is processed here !", HttpStatus.OK);

        return responseEntity;
    }
}
