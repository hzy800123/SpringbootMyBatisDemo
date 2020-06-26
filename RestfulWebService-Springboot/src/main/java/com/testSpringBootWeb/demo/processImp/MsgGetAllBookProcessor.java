package com.testSpringBootWeb.demo.processImp;

import com.testSpringBootWeb.demo.domain.Book;
import com.testSpringBootWeb.demo.mapper.BookMapper;
import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("MsgGetAllBookProcessor")
public class MsgGetAllBookProcessor implements MsgProcessor {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> process(String requestMsg) {
        System.out.println("Processed in Class MsgGetAllBookProcessor");

        List<Book> listBook = new ArrayList<>();
        listBook = bookMapper.getAllBook();

        System.out.println("listBook size is: " + listBook.size());

        return listBook;
    }

}
