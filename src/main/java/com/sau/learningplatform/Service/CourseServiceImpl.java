package com.sau.learningplatform.Service;

import com.sau.learningplatform.Entity.Course;
import com.sau.learningplatform.Entity.User;
import com.sau.learningplatform.EntityResponse.CourseResponse;
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
    public List<CourseResponse> getCoursesByUser(User user) {

        List<Course>courses=courseRepository.findCoursesByUsers(user);

        if (courses.isEmpty()){
            log.warn("no courses found for: {} !",user.getName());
        }
        return courses.stream().map(this::courseToResponse).toList();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getCourseByCode(String courseCode) {
        List<Course>courses=courseRepository.findByCode(courseCode);

        if (courses.size()>1){
            log.error("Multiple courses with same code exists!");
        }

        if (courses.isEmpty()){
            log.error("there is no course with given code !");
        }

        return courses.get(0);


    }


    private CourseResponse courseToResponse(Course course){

       return CourseResponse.builder().
                id(course.getId()).
                code(course.getCode()).
                owner(course.getOwner()).
                title(course.getTitle()).
                build();

    }
}
