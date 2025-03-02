package com.selva.Course_Reg_System.Repo;

import com.selva.Course_Reg_System.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, String> {

}
