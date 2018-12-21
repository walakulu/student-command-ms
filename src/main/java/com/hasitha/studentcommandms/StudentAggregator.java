package com.hasitha.studentcommandms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@EnableBinding(StudentProducerChannel.class)
public class StudentAggregator {

    @Autowired
    private StudentProducerChannel channel;

    private static final String ENTITY_NAME = "student";
    private final Logger log = LoggerFactory.getLogger(StudentAggregator.class);

    @PostMapping("/students")
    public ResponseEntity registerStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        log.debug("REST request to register student : {}", createStudentRequest);
        if (createStudentRequest.getStudentId() == null) {
            throw new RuntimeException("Error processing request :"+ ENTITY_NAME );
        }
        channel.studentProducer().send(message(createStudentRequest));
        return ResponseEntity.ok().body(createStudentRequest);
    }

    private static final <T> Message<T> message(T object) {
        return MessageBuilder.withPayload(object).build();
    }
}
