
package com.example.virtualschools.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Generated("jsonschema2pojo")

@Parcel
public class Course {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("teacher")
    @Expose
    private String teacher;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Course() {
    }

    /**
     * 
     * @param teacher
     * @param school
     * @param name
     * @param description
     * @param id
     */
    public Course(Integer id, String school, String teacher, String name, String description) {
        super();
        this.id = id;
        this.school = school;
        this.teacher = teacher;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
