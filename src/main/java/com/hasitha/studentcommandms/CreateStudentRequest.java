package com.hasitha.studentcommandms;

import lombok.Data;

@Data
public class CreateStudentRequest {
    private String studentId;
    private String firstName;
    private String lastName;

}
