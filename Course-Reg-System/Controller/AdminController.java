package com.selva.Course_Reg_System.Controller;


import com.selva.Course_Reg_System.Model.CourseRegistry;
import com.selva.Course_Reg_System.Model.Users;
import com.selva.Course_Reg_System.Service.CourseService;
import com.selva.Course_Reg_System.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CourseService courseService;

    @Autowired
    userService userService;

    @PostMapping("/add-user")
    public String add(@RequestBody Users user){
        return userService.add(user);
    }

    @GetMapping("courses-enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.getEnrolledStudents();
    }

}
