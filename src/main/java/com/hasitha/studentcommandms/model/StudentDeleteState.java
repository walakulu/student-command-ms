package com.hasitha.studentcommandms.model;

public class StudentDeleteState implements StudentState {
    Student student;

    StudentDeleteState(Student student){
        this.student=student;
    }

    @Override
    public void registerStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void activateStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void suspendStudent() {
        System.out.println("Operation Not Allowed");
    }

    @Override
    public void deleteStudent() {
        this.student.setCurrrentStatus(student.getDeleteState());
    }
}
