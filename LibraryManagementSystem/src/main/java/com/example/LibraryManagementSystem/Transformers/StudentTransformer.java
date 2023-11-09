package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.DTOs.Request.AddStudentDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagementSystem.models.Student;

public class StudentTransformer
{
    public  static Student AddStudentDtoToStudent(AddStudentDto addStudentDto)
    {
      return Student.builder()
                .age(addStudentDto.getAge())
                .name(addStudentDto.getName())
                .emailId(addStudentDto.getEmail())
                .department(addStudentDto.getDepartment())
                .gender(addStudentDto.getGender())
                .build();
    }

    public static StudentResponseDto StudentToStudentResponceDto(Student s)
    {
        return StudentResponseDto.builder()
                .reg(s.getRegNo())
                .email(s.getEmailId())
                .libraryCardId(s.getLibraryCard().getCardId())
                .name(s.getName())
                .department(s.getDepartment())
                .build();
    }
}
