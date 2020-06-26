package com.testSpringBootWeb.demo.processImp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.testSpringBootWeb.demo.domain.Book;
import com.testSpringBootWeb.demo.mapper.BookMapper;
import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("MsgAddNewBookProcessor")
public class MsgAddNewBookProcessor implements MsgProcessor {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> process(String requestMsg) throws Exception {
        System.out.println("Processed in Class MsgAddNewBookProcessor");

        List<Book> listBook = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
            Book newBook = objectMapper.readValue(requestMsg, Book.class);
            System.out.println("newBook: " + newBook.toString());

            int newBookCount = bookMapper.insert(newBook.getTitle(), newBook.getRating());

            listBook = bookMapper.getAllBook();

            System.out.println("newBook count: " + newBookCount);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception();
        }

        return listBook;
    }

}
