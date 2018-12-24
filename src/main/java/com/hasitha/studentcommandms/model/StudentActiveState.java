package com.hasitha.studentcommandms.model;


public class StudentActiveState implements StudentState {

    Student student;

    StudentActiveState(Student student){
        this.student=student;
    }

    @Override
    public void inserttStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void activateStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void suspendStudent() {
        this.student.setCurrrentStatus(student.getSuspendStatus());
    }
}
