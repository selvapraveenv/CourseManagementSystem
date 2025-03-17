package com.selva.Course_Reg_System.Controller;


import com.selva.Course_Reg_System.Model.Course;
import com.selva.Course_Reg_System.Model.CourseRegistry;
import com.selva.Course_Reg_System.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/")
    public String home(){
        return "Home page";
    }

    @PostMapping("courses/register")
    public String courseEnroll(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String courseName){
        return courseService.courseEnroll(name,email,courseName);
    }
}
