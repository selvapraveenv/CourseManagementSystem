package com.selva.Course_Reg_System;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        String sample = "admin1234";
        String hashed = encoder.encode(sample);
        System.out.println(hashed);
    }
}
