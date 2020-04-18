package com.testSpringBootWeb.demo.processImp;

import com.testSpringBootWeb.demo.processInterface.MsgProcessor;
import org.springframework.stereotype.Component;

@Component("MsgTwoProcessor")
public class MsgTwoProcessor implements MsgProcessor {

    @Override
    public String process(String inputParam) {
        String resultString = null;
        resultString = inputParam.concat(" is processed in Class MsgTwoProcessor.");

        return resultString;
    }
}
