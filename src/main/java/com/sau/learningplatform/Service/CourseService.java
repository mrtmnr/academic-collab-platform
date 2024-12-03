package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Course;
import com.sau.learningplatform.Entity.User;

import java.util.List;

public interface CourseService {

    List<Course> getCoursesByUser(User user);
}
