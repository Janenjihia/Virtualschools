
package com.example.virtualschools.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Generated("jsonschema2pojo")

@Parcel
public class StudentDetails {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("createdat")
    @Expose
    private String createdat;
    @SerializedName("updatedat")
    @Expose
    private String updatedat;
    @SerializedName("role")
    @Expose
    private String role;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StudentDetails() {
    }

    /**
     * 
     * @param createdat
     * @param password
     * @param role
     * @param name
     * @param id
     * @param email
     * @param updatedat
     */
    public StudentDetails(Integer id, String name, String email, String password, String createdat, String updatedat, String role) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(String updatedat) {
        this.updatedat = updatedat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
