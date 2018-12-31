package com.hasitha.studentcommandms.model;

public class StudentSuspendState implements StudentState {

    Student student;

    StudentSuspendState(Student student){
        this.student=student;
    }

    @Override
    public void registerStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void activateStudent() {
        this.student.setCurrrentStatus(student.getActiveStatus());
    }

    @Override
    public void suspendStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void deleteStudent() {

    }
}
