package com.hasitha.studentcommandms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;


public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private StudentActiveState activeStatus;
    @JsonIgnore
    private StudentPendingState pendingStatus;
    @JsonIgnore
    private StudentSuspendState suspendStatus;
    @JsonIgnore
    private StudentDeleteState deleteState;
    private StudentState currrentStatus;

    Student(){
        this.activeStatus=new StudentActiveState(this);
        this.pendingStatus=new StudentPendingState(this);
        this.suspendStatus=new StudentSuspendState(this);
        this.deleteState=new StudentDeleteState(this);
        this.currrentStatus=pendingStatus;
    }

    public StudentState getCurrrentStatus(){
        return this.currrentStatus;
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

    public StudentDeleteState getDeleteState() {
        return deleteState;
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

////////////////////////////////////////////////////////

    public void registerStudent(){
        this.currrentStatus.registerStudent();
        //Call for db to persist data
    }

    public void activateStudent(){

    }

    public void suspendStudent(){

    }


}
