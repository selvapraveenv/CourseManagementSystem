package com.selva.Course_Reg_System.Service;

import com.selva.Course_Reg_System.Model.Course;
import com.selva.Course_Reg_System.Model.CourseRegistry;
import com.selva.Course_Reg_System.Repo.CourseRegistryRepo;
import com.selva.Course_Reg_System.Repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    public List<CourseRegistry> getEnrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public String courseEnroll(String name, String email, String courseName) {
        CourseRegistry newCourse = new CourseRegistry(name,email,courseName);
        courseRegistryRepo.save(newCourse);
        return "Congrats! " + name + ", Successfully enrolled in " + courseName + ".";
    }
}
