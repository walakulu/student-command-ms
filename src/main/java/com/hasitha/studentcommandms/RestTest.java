package com.hasitha.studentcommandms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {

    @Autowired
    private StudentMessageProducer studentMessageProducer;

    @RequestMapping("/greeting")
    public void greeting() {
        studentMessageProducer.produceData();
    }
}
