package com.hasitha.studentcommandms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import java.util.Scanner;

@EnableBinding({StudentProducerChannel.class})
public class StudentMessageProducer {
    @Autowired
    private StudentProducerChannel helloOutboundStream;

    //If there is method which consumes and produce data,the use @StreamListner with @SendTo to automatically convert response to Message
    public void produceData(){
        Student student=new Student();
        System.out.println("Please Enter ID :");
        Scanner sc=new Scanner(System.in);
        student.setIdNumber(sc.nextLine());
        System.out.println("Please Enter First tName :");
        student.setFirstName(sc.nextLine());
        System.out.println("Please Enter Last tName :");
        student.setLastName(sc.nextLine());
        String inputText=sc.nextLine();
        helloOutboundStream.studentProducer().send(message(student));
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }


}
