package com.hasitha.studentcommandms.events;

import com.hasitha.studentcommandms.model.Student;
import lombok.Data;

@Data
public class CreateStudentEvent  {
    private Student student;
    private EventType eventType;

    public CreateStudentEvent( Student student ){
        this.student=student;
        this.eventType=EventType.STUDENT_CREATED;
    }

}
