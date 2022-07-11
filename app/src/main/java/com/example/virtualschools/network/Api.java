package com.example.virtualschools.network;

import com.example.virtualschools.models.Course;
import com.example.virtualschools.models.Login;
import com.example.virtualschools.models.Resource;
import com.example.virtualschools.models.Student;
import com.example.virtualschools.models.StudentDetails;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface Api {
    //login
    @POST("users/login") Call<Student> login (@Body Login login);

    //get student details
    @GET("users") Call<StudentDetails> getStudentDetails(@Header("Authorization") String token);

    //update student details
    @PATCH("users") Call<StudentDetails> patchStudentDetails(@Header("Authorization") String token);

    //get courses
    @GET("courses") Call<Course> getCourses(@Header("Authorization") String token);

    //get resources
    @GET("resources") Call<Resource> getResources(@Header("Authorization") String token);

}
