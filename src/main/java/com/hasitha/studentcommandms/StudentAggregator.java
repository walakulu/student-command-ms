package com.hasitha.studentcommandms;

import com.hasitha.studentcommandms.command.RegisterStudent;
import com.hasitha.studentcommandms.config.StudentProducerChannel;
import com.hasitha.studentcommandms.events.CreateStudentEvent;
import com.hasitha.studentcommandms.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@EnableBinding(StudentProducerChannel.class)
public class StudentAggregator {

    @Autowired
    private StudentProducerChannel channel;

    private static final String ENTITY_NAME = "student";
    private final Logger log = LoggerFactory.getLogger(StudentAggregator.class);

    @PostMapping("/register")
    public ResponseEntity registerStudent(@RequestBody RegisterStudent registerStudent) {
        log.debug("REST request to register student : {}", registerStudent);
        //subtract the student from command
        Student student=registerStudent.getStudent();
        if (student.getStudentId() == null) {
            throw new RuntimeException("Error processing request :"+ ENTITY_NAME );
        }
        channel.studentProducer().send(message(new CreateStudentEvent(student)));

       // student.suspendStudent();
        student.registerStudent();
        student.activateStudent();
        return ResponseEntity.ok().body(student);
    }

    /**
     * <p>Build a {@link Message} with given payload</p>
     * @param message the message
     * @param <T>
     * @return the {@link Message} object
     */
    private static final <T> Message<T> message(T message) {
        return MessageBuilder.withPayload(message).build();
    }
}
