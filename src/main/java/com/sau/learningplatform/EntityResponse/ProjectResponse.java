package com.sau.learningplatform.EntityResponse;

import com.sau.learningplatform.Entity.Course;
import lombok.Data;


@Data
public class ProjectResponse {

    private int id;


    private Course course;


    private String title;


    private String description;
}
