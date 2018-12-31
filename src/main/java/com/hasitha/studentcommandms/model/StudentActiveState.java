package com.hasitha.studentcommandms.model;


public class StudentActiveState implements StudentState {

    Student student;

    StudentActiveState(Student student){
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
        this.student.setCurrrentStatus(student.getSuspendStatus());
    }

    @Override
    public void deleteStudent() {
        this.student.setCurrrentStatus(student.getDeleteState());
    }
}
