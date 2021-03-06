package com.hasitha.studentcommandms.model;

public class StudentPendingState implements StudentState {

    Student student;

    StudentPendingState(Student student){
        this.student=student;
    }

    @Override
    public void registerStudent() {
        this.student.setCurrrentStatus(student.getPendingStatus());
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
