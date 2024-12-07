package com.sau.learningplatform.Controller;

import com.sau.learningplatform.Entity.Course;
import com.sau.learningplatform.Entity.User;
import com.sau.learningplatform.EntityResponse.CourseResponse;
import com.sau.learningplatform.Service.CourseService;
import com.sau.learningplatform.Service.UserService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    private CourseService courseService;

    private UserService userService;

    public HomeController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String homepage(Model model){
        //mock user
        User user=userService.findById(2);
        List<CourseResponse>courses=courseService.getCoursesByUser(user);
        model.addAttribute("courses",courses);

        return "home/index";
    }

    @PostMapping("/addCourse")
    public Course addCourse(
            @RequestParam("courseName") String courseName,
            @RequestParam("courseCode") String courseCode,
            @RequestParam("file") MultipartFile studentFile,
            Model model
    ) throws IOException {
        // Parse the uploaded Excel file
        List<User> students = saveStudentsByFile(studentFile);

        // get a course, save and associate students with it
        Course course=new Course(courseName,"owner",courseCode);

        students.forEach(course::addUser);

        courseService.save(course);

       //model.addAttribute("course",course);

        return course;   // Redirect to the add-course page with success message
    }

    private List<User> saveStudentsByFile(MultipartFile file) throws IOException {
        List<User> students = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);  // Get the first sheet
            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {  // Skip header row
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    String name = row.getCell(0).getStringCellValue();
                    String surname = row.getCell(1).getStringCellValue();
                    String number = row.getCell(2).getStringCellValue();

                    User student = new User(number,name,surname,number,"student");
                    students.add(student);
                }
            }
        }
        return students;
    }
}
