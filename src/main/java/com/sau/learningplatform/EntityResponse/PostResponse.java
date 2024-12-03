package com.sau.learningplatform.EntityResponse;

import com.sau.learningplatform.Entity.Post;
import com.sau.learningplatform.Entity.Project;
import com.sau.learningplatform.Entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class PostResponse {

    private int id;


    private User user;


    private Project project;


    private Post parentPost;


    private String text;

    private String status;


    private Date dateCreated;

    private Boolean isSolved;
}
