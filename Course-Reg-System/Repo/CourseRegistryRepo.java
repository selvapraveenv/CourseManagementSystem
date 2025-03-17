package com.selva.Course_Reg_System.Repo;

import com.selva.Course_Reg_System.Model.CourseRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistryRepo extends JpaRepository<CourseRegistry,Integer> {
}
