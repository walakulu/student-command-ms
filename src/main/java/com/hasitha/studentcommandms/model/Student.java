package com.hasitha.studentcommandms.model;

import lombok.Data;
import java.util.List;


public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private StudentActiveState activeStatus;
    private StudentPendingState pendingStatus;
    private StudentSuspendState suspendStatus;
    private StudentState currrentStatus;

    Student(){
        this.activeStatus=new StudentActiveState(this);
        this.pendingStatus=new StudentPendingState(this);
        this.suspendStatus=new StudentSuspendState(this);
        this.currrentStatus=pendingStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentState getCurrrentStatus() {
        return currrentStatus;
    }

    public void setCurrrentStatus(StudentState currrentStatus) {
        this.currrentStatus = currrentStatus;
    }

    public StudentActiveState getActiveStatus() {
        return activeStatus;
    }

    public StudentPendingState getPendingStatus() {
        return pendingStatus;
    }

    public StudentSuspendState getSuspendStatus() {
        return suspendStatus;
    }

    public void activateStudent(){
        currrentStatus.activateStudent();
    }

    public void susPendStudent(){
        currrentStatus.suspendStudent();
    }
}
