package com.hasitha.studentcommandms.command;

import com.hasitha.studentcommandms.model.Student;

public class RegisterStudentCommand implements Command {

    private Student student;

    public RegisterStudentCommand(Student student){
        this.student=student;
    }

    @Override
    public void execute() {
        student.registerStudent();
    }
}
