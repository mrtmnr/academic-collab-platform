package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Project;
import com.sau.learningplatform.EntityResponse.ProjectResponse;

import java.util.List;

public interface ProjectService {
    Project findById(int id);

    List<ProjectResponse> getProjectsByCourseId(int courseId);
}
