package com.example.LibraryManagementSystem.DTOs.Request;

import com.example.LibraryManagementSystem.enums.Department;
import com.example.LibraryManagementSystem.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentDto
{
    String name;
    Department department;
    String email;
    int age;
    Gender gender;

}
