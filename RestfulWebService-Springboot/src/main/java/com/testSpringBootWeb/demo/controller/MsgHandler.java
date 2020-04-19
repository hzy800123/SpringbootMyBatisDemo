package com.testSpringBootWeb.demo.controller;

import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import com.testSpringBootWeb.demo.webObject.WebResponse;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MsgHandler {
    @Autowired
    private ApplicationContext applicationContext;

    // Request URL:
    // http://127.0.0.1:9090/num?num=123456
    // Response Message:
    // The input Num 123456 is processed here.
    @SuppressWarnings("rawtypes")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/num")
    public ResponseEntity messageNumHandler(@RequestParam(name = "num") int num) {
        System.out.println(" ------ Start to process method messageNumHandler() ------ ");
        System.out.println(" Input num: " + num);

        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity<>("The input Num " + num + " is processed here.", HttpStatus.OK);

        System.out.println(" -------------------------- ");
        return responseEntity;
    }


    // Request URL:
    // http://127.0.0.1:9090/request/One
    // Request Body:
    // {"id":"123","date":"20200419"}
    // Response Message:
    // {"id":"123","date":"20200419","result":"This is Result of MsgOneProcessor."}
    @SuppressWarnings("rawtypes")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/request/{requestId}")
    public ResponseEntity messageHandler(
            @PathVariable("requestId") String requestId,
            @RequestBody String requestMsg) {

        System.out.println(" ------ Start to process method messageHandler() ------ ");
        System.out.println("requestId: " + requestId);
        ResponseEntity responseEntity = null;

        try {
            MsgProcessor msgProcessor = (MsgProcessor)applicationContext.getBean("Msg" + requestId + "Processor");
            WebResponse webResponse = msgProcessor.process(requestMsg);
            responseEntity = new ResponseEntity<>(webResponse, HttpStatus.OK);

        } catch (NoSuchBeanDefinitionException e) {
            responseEntity = new ResponseEntity<>("No such bean definition !", HttpStatus.OK);
            System.out.println(" No such bean definition ! ");
        }

        System.out.println(" -------------------------- ");
        return responseEntity;
    }


    @SuppressWarnings("rawtypes")
    @GetMapping(value = "/*")
    public ResponseEntity otherMessageHandler() {
        System.out.println(" ------ Start to process method otherMessageHandler() ------ ");

        ResponseEntity responseEntity = null;
        responseEntity = new ResponseEntity<>("Other message is processed here !", HttpStatus.OK);

        return responseEntity;
    }
}


/*

fetch('http://127.0.0.1:9090/request/One', {
  method: 'POST',
  body: JSON.stringify({
    id: '123',
    date: '20200419',
  }),
  headers: {
    'Content-type': 'application/json; charset=UTF-8'
  },
  mode: 'no-cors',
})
.then(res => res.json())
.then(console.log)

 */