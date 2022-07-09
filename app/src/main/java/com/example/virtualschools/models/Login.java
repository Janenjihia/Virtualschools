package com.example.virtualschools.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")

@Parcel
public class Login {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    /**
     * No args constructor for use in serialization
     *
     */
    public Login() {
    }

    /**
     *
     * @param email
     * @param password
     */

    public Login(String email, String password){
        this.email = email;
        this.password =password;
    }
}
