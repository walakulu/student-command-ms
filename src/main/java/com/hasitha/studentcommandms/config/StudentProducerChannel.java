package com.hasitha.studentcommandms.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StudentProducerChannel {

    String OUTPUT ="student-producer-channel";

    @Output(StudentProducerChannel.OUTPUT)
    MessageChannel studentProducer();
}
