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

@Component("MsgDeleteBookProcessor")
public class MsgDeleteBookProcessor implements MsgProcessor {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> process(String requestMsg) throws Exception {
        System.out.println("Processed in Class MsgDeleteBookProcessor");

        List<Book> listBook = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
            Book deleteBook = objectMapper.readValue(requestMsg, Book.class);
            System.out.println("deleteBook: " + deleteBook.toString());

            // int deleteBookId = Integer.parseInt(requestMsg);
            System.out.println("Delete the Book ID: " + deleteBook.getId());

            int resultDeleteCount = bookMapper.delete(deleteBook.getId());
            listBook = bookMapper.getAllBook();

            System.out.println("Delete Count: " + resultDeleteCount);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception();
        }

        return listBook;
    }

}
