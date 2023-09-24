package com.example.LibraryManagementSystem.repository;


import com.example.LibraryManagementSystem.Enums.Gender;
import com.example.LibraryManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends JpaRepository<Student,Integer> {


    List<Student> findAllByGender(Gender gender);
}
