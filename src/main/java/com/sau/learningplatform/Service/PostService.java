package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsByProjectId(int id);
}
