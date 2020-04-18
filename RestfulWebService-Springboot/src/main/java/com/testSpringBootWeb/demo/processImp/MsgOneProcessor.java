package com.testSpringBootWeb.demo.processImp;

import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import org.springframework.stereotype.Component;

@Component("MsgOneProcessor")
public class MsgOneProcessor implements MsgProcessor {

    @Override
    public String process(String inputParam) {
        String resultString = null;
        resultString = inputParam.concat(" is processed in Class MsgOneProcessor.");

        return resultString;
    }
}
