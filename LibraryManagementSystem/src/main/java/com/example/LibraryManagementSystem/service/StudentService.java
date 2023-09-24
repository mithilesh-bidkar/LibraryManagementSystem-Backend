package com.example.LibraryManagementSystem.service;


import com.example.LibraryManagementSystem.DTO.Request.StudentRequest;
import com.example.LibraryManagementSystem.DTO.Respsonse.StudentResponse;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Enums.Gender;
import com.example.LibraryManagementSystem.model.LibraryCard;
import com.example.LibraryManagementSystem.model.Student;
import com.example.LibraryManagementSystem.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRespository studentRespository;

    public StudentResponse addStudent(StudentRequest studentRequest) {

        Student student  = new Student();

        student.setAge(studentRequest.getAge());
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());


        LibraryCard libraryCard = new LibraryCard();

        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);
        Student savedStudent = studentRespository.save(student);

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setEmail(savedStudent.getEmail());
        studentResponse.setName(savedStudent.getName());
        studentResponse.setLibraryCardIssuedNo(savedStudent.getLibraryCard().getCardNo());
        studentResponse.setMessage("Student added Successfully !!");

        return studentResponse;
    }

    public Student getStudent(int regNo) {

        Optional<Student> optionalStudent = studentRespository.findById(regNo);

        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }

        return null;
    }

    public String deleteStudent(int regNo) {

        if(this.getStudent(regNo)!=null){
            studentRespository.deleteById(regNo);
            return "student deleted successfully";
        }

        return null;
    }

    public Student updateAge(int regNo, int age) {

        Optional<Student> currStudent = studentRespository.findById(regNo);

        if(currStudent.isPresent()){

            currStudent.get().setAge(age);
            studentRespository.save(currStudent.get());

            return currStudent.get();
        }

        return null;
    }

    public List<Student> getAllStudent() {

        List<Student> studentList = new ArrayList<>();

        studentList=studentRespository.findAll();

        return studentList;
    }

    public List<Student> getMaleStudent() {


        return studentRespository.findAllByGender(Gender.MALE);

    }
}
