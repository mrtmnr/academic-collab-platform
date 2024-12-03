package com.sau.learningplatform.EntityResponse;

import com.sau.learningplatform.Entity.User;
import lombok.Data;

import java.util.List;

@Data
public class CourseResponse {

    private int id;

    private List<User> users;


    private String title;


    private String code;


    private Boolean isDeleted;
}
