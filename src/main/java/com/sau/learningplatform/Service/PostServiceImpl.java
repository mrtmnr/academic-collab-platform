package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Post;
import com.sau.learningplatform.Repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<Post> getPostsByProjectId(int id) {
        List<Post>posts=postRepository.findByProjectId(id);
        if (posts.isEmpty()){
            log.info("No posts found for the given project!");
        }
        return posts;
    }
}
