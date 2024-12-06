package com.sau.learningplatform.EntityResponse;

import com.sau.learningplatform.Entity.Project;
import com.sau.learningplatform.Entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseResponse {

    private int id;

    private String owner;

    private String title;

    private String code;



}
