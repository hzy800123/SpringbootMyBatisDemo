package com.testSpringBootWeb.demo.processImp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import com.testSpringBootWeb.demo.webObject.WebRequest;
import com.testSpringBootWeb.demo.webObject.WebResponse;
import org.springframework.stereotype.Component;

@Component("MsgOneProcessor")
public class MsgOneProcessor implements MsgProcessor {

    @Override
    public WebResponse process(String requestMsg) {
        System.out.println("Processed in Class MsgOneProcessor");

        WebRequest webRequest = null;
        WebResponse webResponse = new WebResponse();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
            webRequest = objectMapper.readValue(requestMsg, WebRequest.class);
            System.out.println("webRequest: " + webRequest.toString());

            webResponse.setId(webRequest.getId());
            webResponse.setDate(webRequest.getDate());
            webResponse.setResult("This is Result of MsgOneProcessor.");

            System.out.println("webResponse: " + webResponse.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return webResponse;
    }
}
