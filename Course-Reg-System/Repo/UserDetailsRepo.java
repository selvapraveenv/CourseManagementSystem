package com.selva.Course_Reg_System.Repo;

import com.selva.Course_Reg_System.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users,Integer> {

    Users getByUsername(String username);
}
