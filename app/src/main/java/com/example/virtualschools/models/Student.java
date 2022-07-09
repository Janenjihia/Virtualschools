
package com.example.virtualschools.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Generated("jsonschema2pojo")

@Parcel
public class Student {

    @SerializedName("studentDetails")
    @Expose
    private StudentDetails studentDetails;
    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Student() {
    }

    /**
     * 
     * @param studentDetails
     * @param token
     */
    public Student(StudentDetails studentDetails, String token) {
        super();
        this.studentDetails = studentDetails;
        this.token = token;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
