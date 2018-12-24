package com.hasitha.studentcommandms;

import com.hasitha.studentcommandms.config.StudentProducerChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

//@EnableBinding annotation to your application to get immediate connectivity to a message broker
@SpringBootApplication
//@EnableBinding({HelloInboundStream.class,StudentProducerChannel.class})
public class StudentCommandMs {

	public static void main(String[] args) {
		SpringApplication.run(StudentCommandMs.class, args);

	}
	//ull destination=channelname+groupName
	//Ex:spring.cloud.stream.bindings.input.group=myGroup,   destination name 'input.myGroup'
	@ServiceActivator(inputChannel = StudentProducerChannel.OUTPUT+".student-command-ms-group.errors")
	public void error(Message<?> message) {
		System.out.println("Handling ERROR: " + message);
	}

}