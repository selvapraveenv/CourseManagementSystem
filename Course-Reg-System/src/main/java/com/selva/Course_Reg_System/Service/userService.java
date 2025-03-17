package com.selva.Course_Reg_System.Service;

import com.selva.Course_Reg_System.Model.Users;
import com.selva.Course_Reg_System.Repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    UserDetailsRepo userDetailsRepo;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public String add(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);
        return "User " + user.getUsername() + " added!";
    }
}
