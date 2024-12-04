package com.sau.learningplatform.Controller;

import com.sau.learningplatform.Entity.Post;
import com.sau.learningplatform.Service.PostService;
import com.sau.learningplatform.Service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

    @GetMapping("/posts")
    public String postsByProject(Model model){
        //mock project
       int projectId=1;
       List<Post> posts= postService.getPostsByProjectId(projectId);
       model.addAttribute("posts",posts);

       return "home/posts";

    }




}
