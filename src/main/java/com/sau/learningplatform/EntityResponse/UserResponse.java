package com.sau.learningplatform.EntityResponse;

import com.sau.learningplatform.Entity.Course;
import lombok.Data;
import java.util.Set;

@Data
public class UserResponse {


    private int id;

    private Set<Course> courses;


    private String number;


    private String name;


    private String surname;


    private String password;


    private String role;

}
