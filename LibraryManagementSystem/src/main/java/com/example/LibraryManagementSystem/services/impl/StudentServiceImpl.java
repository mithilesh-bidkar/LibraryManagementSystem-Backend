package com.example.LibraryManagementSystem.services.impl;


import com.example.LibraryManagementSystem.CustomException.StudentRelatedException.StudentNotFoundException;
import com.example.LibraryManagementSystem.DTOs.Request.AddStudentDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagementSystem.Transformers.LibraryCardTransformer;
import com.example.LibraryManagementSystem.Transformers.StudentTransformer;
import com.example.LibraryManagementSystem.enums.Department;
import com.example.LibraryManagementSystem.enums.Gender;
import com.example.LibraryManagementSystem.models.LibraryCard;
import com.example.LibraryManagementSystem.models.Student;
import com.example.LibraryManagementSystem.repositories.StudentRepository;
import com.example.LibraryManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponseDto addStudent (AddStudentDto addStudentDto)
    {

        Student student= StudentTransformer.AddStudentDtoToStudent(addStudentDto);

        LibraryCard libraryCard= LibraryCardTransformer.GenerateLibraryCardForStudent(student);

         student.setLibraryCard(libraryCard);  //allocated library_card to the Student..

         student= studentRepository.save(student); //saved both student and library card.. here because bidirectional mapping.

        StudentResponseDto studentResponseDto =StudentTransformer.StudentToStudentResponceDto(student);

        return studentResponseDto;
    }

    public Department getDeptById(Integer id) throws  Exception
    {
        Optional<Student>optionalStudent=studentRepository.findById(id);
        if(optionalStudent.isPresent()==false)throw new Exception("Student with Id is not found");

        Student student=optionalStudent.get();
        return student.getDepartment();
    }

    public String deleteStudent(Integer regNo) throws Exception
    {
        Optional<Student>optionalStudent=studentRepository.findById(regNo);
        if(optionalStudent.isEmpty())throw new StudentNotFoundException("Student Not Found Exception");

        studentRepository.delete(optionalStudent.get());

        return "Student Delete Successfully!!";
    }

    public StudentResponseDto updateAge(int age, int regNo)
    {
        Optional<Student>optionalStudent=studentRepository.findById(regNo);
        if(optionalStudent.isEmpty())throw new StudentNotFoundException("Student Not Found Exception");

        Student student=optionalStudent.get();
        student.setAge(age);

      student= studentRepository.save(student);

      StudentResponseDto studentResponseDto =StudentTransformer.StudentToStudentResponceDto(student);

        return studentResponseDto;
    }

    public List<StudentResponseDto> getAllMaleStudents(Gender gender)
    {

        List<Student>studentList=studentRepository.findByGender(gender);

        List<StudentResponseDto> studentResponseDtos =new ArrayList<>();
        for(Student student:studentList)
        {
            StudentResponseDto studentResponseDto =StudentTransformer.StudentToStudentResponceDto(student);

            studentResponseDtos.add(studentResponseDto);
        }

        return studentResponseDtos;
    }

    public List<StudentResponseDto> getAllStudents()
    {
        List<Student>studentList=studentRepository.findAll();

        List<StudentResponseDto> studentResponseDtos =new ArrayList<>();
        for(Student student:studentList)
        {
            StudentResponseDto studentResponseDto =StudentTransformer.StudentToStudentResponceDto(student);
            studentResponseDtos.add(studentResponseDto);
        }
        return studentResponseDtos;
    }
}
