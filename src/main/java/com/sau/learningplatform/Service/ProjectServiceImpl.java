package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Project;
import com.sau.learningplatform.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project findById(int id) {
        Optional<Project>result=projectRepository.findById(id);

        if (result.isEmpty()){
            throw new RuntimeException("Project not found with given id !");
        }
        return result.get();
    }
}
