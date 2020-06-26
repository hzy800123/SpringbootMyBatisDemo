package com.testSpringBootWeb.demo.processInterface;

import com.testSpringBootWeb.demo.webObject.WebRequest;
import com.testSpringBootWeb.demo.webObject.WebResponse;

import java.util.List;

public interface MsgProcessor {
    public List<?> process(String requestMsg) throws Exception;
//    public WebResponse process(String requestMsg);
}
