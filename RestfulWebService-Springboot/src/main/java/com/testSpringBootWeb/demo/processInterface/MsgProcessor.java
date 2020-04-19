package com.testSpringBootWeb.demo.processInterface;

import com.testSpringBootWeb.demo.webObject.WebRequest;
import com.testSpringBootWeb.demo.webObject.WebResponse;

public interface MsgProcessor {
    public WebResponse process(String requestMsg);
}
