package com.testSpringBootWeb.demo.controller;

import com.testSpringBootWeb.demo.domain.Book;
import com.testSpringBootWeb.demo.domain.Staff;
import com.testSpringBootWeb.demo.mapper.BookMapper;
import com.testSpringBootWeb.demo.mapper.StaffMapper;
import com.testSpringBootWeb.demo.processImp.MsgGetAllBookProcessor;
import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

//@Controller
@RestController
public class MsgHandler {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private StaffMapper userMapper;

    // Request URL:
    // http://127.0.0.1:9090/num?num=123456
    // Response Message:
    // The input Num 123456 is processed here.
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/num")
//    public ResponseEntity<String> messageNumHandler(@RequestParam(name = "num") String num) {
//        System.out.println(" ------ Start to process method messageNumHandler() ------ ");
//        System.out.println(" Input num: " + num);
//
//        ResponseEntity<String> responseEntity = null;
//        responseEntity = new ResponseEntity<>("Spring-boot Testing - The input Num " + num + " is processed here.", HttpStatus.OK);
//
//        System.out.println(" -------------------------- ");
//        return responseEntity;
//    }


    // Request URL:
    // http://127.0.0.1:9090/request/One
    // Request Body:
    // {"id":"123","date":"20200419"}
    // Response Message:
    // {"id":"123","date":"20200419","result":"This is Result of MsgOneProcessor."}
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/request/{requestId}")
//    public ResponseEntity messageHandler(
//            @PathVariable("requestId") String requestId,
//            @RequestBody String requestMsg) {
//
//        System.out.println(" ------ Start to process method messageHandler() ------ ");
//        System.out.println("requestId: " + requestId);
//        ResponseEntity responseEntity = null;
//
//        try {
//            MsgProcessor msgProcessor = (MsgProcessor)applicationContext.getBean("Msg" + requestId + "Processor");
//            WebResponse webResponse = msgProcessor.process(requestMsg);
//            responseEntity = new ResponseEntity<>(webResponse, HttpStatus.OK);
//
//        } catch (NoSuchBeanDefinitionException e) {
//            responseEntity = new ResponseEntity<>("No such bean definition !", HttpStatus.OK);
//            System.out.println(" No such bean definition ! ");
//        }
//
//        System.out.println(" -------------------------- ");
//        return responseEntity;
//    }


    // 访问 MySQL 数据库：
    // select * from staff
    //
    // Request URL:
    // http://47.107.105.61:9090/getallbook
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value="/getallbook", method=RequestMethod.GET)
//    public ResponseEntity<List<Book>> getAllBook() {
//        System.out.println(" --- Start to get All Book from MySQL Database. --- ");
//
//        List<Book> listBook = bookMapper.getAllBook();
//
//        System.out.println(listBook);
//        int count = listBook.size();
//
//        ResponseEntity<List<Book>> responseEntity = null;
//        responseEntity = new ResponseEntity<>(listBook, HttpStatus.OK);
//
//        System.out.println(" -------------------------- ");
//        return responseEntity;
//    }



    // 修改 MySQL 数据库，增加一条新的记录
    // insert into books(title, rating) values(#{title}, #{rating})
    //
    // Request URL:
    // http://47.107.105.61:9090/getallbook
    @SuppressWarnings("rawtypes")
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/book/{requestId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity msgBookHandler(
            @PathVariable("requestId") String requestId,
            @RequestBody(required = false) String requestMsg) {

        System.out.println(" --- Start to process in MySQL Database. --- ");
        System.out.println("Current Date and Time: " + LocalDate.now() + " - " + LocalTime.now());

        String beanName = "Msg" + requestId + "Processor";
        System.out.println("Bean: " + beanName);
        ResponseEntity responseEntity = null;
        MsgProcessor msgProcessor = null;
        MsgGetAllBookProcessor msgGetAllBookProcessor = null;

        try {
            msgProcessor = (MsgProcessor)applicationContext.getBean(beanName);
            List<?> listBook = msgProcessor.process(requestMsg);
            responseEntity = new ResponseEntity<>(listBook, HttpStatus.OK);

        } catch (NoSuchBeanDefinitionException e) {
            responseEntity = new ResponseEntity<>("No such bean definition !", HttpStatus.OK);
            System.out.println(" No such bean definition ! ");
        } catch (Exception e) {
            System.out.println("Catch Exception " + e);

//            msgGetAllBookProcessor = (MsgGetAllBookProcessor)applicationContext.getBean("MsgGetAllBookProcessor");
//            List<?> listBook = msgGetAllBookProcessor.process(requestMsg);
            responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        System.out.println("Current Date and Time: " + LocalDate.now() + " - " + LocalTime.now());
        System.out.println(" -------------------------- ");
        return responseEntity;
    }


    // 访问 MySQL 数据库：
    // select * from staff
    //
    // Request URL:
    // http://47.107.105.61:9090/getall
    // Response:
    // Spring-boot Testing - Staff Count: 7 -
    // Staff List:
    // [ Staff - { id = 7, name = '国产007', age = 30, salary = 7.77 } ,
    // Staff - { id = 8, name = '我是谁', age = 18, salary = 8888.0 } ,
    // Staff - { id = 10, name = 'John', age = 30, salary = 1000.0 } ,
    // Staff - { id = 11, name = 'Adam', age = 18, salary = 888.88 } ,
    // Staff - { id = 12, name = 'Adam', age = 18, salary = 888.88 } ,
    // Staff - { id = 13, name = 'Adam', age = 18, salary = 888.88 } ,
    // Staff - { id = 14, name = 'Adam', age = 18, salary = 888.88 } ]
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value="/getall", method=RequestMethod.GET)
//    public ResponseEntity<String> getAllStaff() {
//        System.out.println(" --- Start to get All staff from MySQL Database. --- ");
//
//        List<Staff> listStaff = userMapper.getAll();
//
//        System.out.println(listStaff);
//        int count = listStaff.size();
//
//        ResponseEntity<String> responseEntity = null;
//        responseEntity = new ResponseEntity<>("Spring-boot Testing - Staff Count: "
//                + count
//                + " - Staff List: "
//                + listStaff
//                , HttpStatus.OK);
//
//        System.out.println(" -------------------------- ");
//        return responseEntity;
//    }

    // 访问 MySQL 数据库：
    // insert into staff(id, name, age, salary) values(#{id}, #{name}, #{age}, #{salary})
    //
    // Request URL:
    // http://47.107.105.61:9090/insert
    // Response:
    // Spring-boot Testing - Insert Successful ! Insert Count = 1
//    @SuppressWarnings("rawtypes")
//    @RequestMapping(value="/insert", method=RequestMethod.POST)
//    public ResponseEntity<String> insert() {
//        System.out.println(" --- Start to insert new staff into MySQL Database. --- ");
//
//        int maxId = userMapper.getMaxId();
//
//        Staff staff = new Staff();
//        staff.setId(maxId + 1);
//        staff.setAge(18);
//        staff.setName("Adam");
//        staff.setSalary(888.88);
//        int result = userMapper.insert(staff);
//        String resultMsg;
//        if (result == 1) {
//            resultMsg = "Insert Successful ! Insert Count = " + result;
//        } else {
//            resultMsg = "Insert Failed";
//        }
//
//        ResponseEntity<String> responseEntity = null;
//        responseEntity = new ResponseEntity<>("Spring-boot Testing - " + resultMsg, HttpStatus.OK);
//
//        System.out.println(" -------------------------- ");
//        return responseEntity;
//    }


//    @SuppressWarnings("rawtypes")
//    @GetMapping(value = "/*")
//    public ResponseEntity otherMessageHandler() {
//        System.out.println(" ------ Start to process method otherMessageHandler() ------ ");
//
//        ResponseEntity responseEntity = null;
//        responseEntity = new ResponseEntity<>("Other message is processed here !", HttpStatus.OK);
//
//        return responseEntity;
//    }
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