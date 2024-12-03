package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Course;
import com.sau.learningplatform.Entity.User;
import com.sau.learningplatform.Repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCoursesByUser(User user) {

        List<Course>courses=courseRepository.findCoursesByUsers(user);

        if (courses.isEmpty()){
            log.error("no courses found for: {} !",user.getName());
        }
        return courseRepository.findCoursesByUsers(user);
    }
}
