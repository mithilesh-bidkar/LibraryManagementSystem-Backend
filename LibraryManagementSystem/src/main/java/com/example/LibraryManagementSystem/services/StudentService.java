package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.DTOs.Request.AddStudentDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagementSystem.enums.Department;
import com.example.LibraryManagementSystem.enums.Gender;

import java.util.List;

public interface StudentService
{
    public StudentResponseDto addStudent (AddStudentDto addStudentDto);
    public Department getDeptById(Integer id) throws  Exception;
    public String deleteStudent(Integer regNo) throws Exception;
    public StudentResponseDto updateAge(int age, int regNo);
    public List<StudentResponseDto> getAllMaleStudents(Gender gender);
    public List<StudentResponseDto> getAllStudents();
}
