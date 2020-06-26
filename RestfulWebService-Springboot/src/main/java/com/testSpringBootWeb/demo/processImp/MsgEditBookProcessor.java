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

@Component("MsgEditBookProcessor")
public class MsgEditBookProcessor implements MsgProcessor {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> process(String requestMsg) throws Exception {
        System.out.println("Processed in Class MsgEditBookProcessor");

        List<Book> listBook = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
            Book editBook = objectMapper.readValue(requestMsg, Book.class);
            System.out.println("editBook: " + editBook.toString());

            int resultEditCount = bookMapper.update(editBook.getId(), editBook.getTitle(), editBook.getRating());

            listBook = bookMapper.getAllBook();

            System.out.println("Edit Count: " + resultEditCount);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception();
        }

        return listBook;
    }

}
