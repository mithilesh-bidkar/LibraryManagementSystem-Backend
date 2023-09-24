package com.example.LibraryManagementSystem.controller;


import com.example.LibraryManagementSystem.DTO.Request.StudentRequest;
import com.example.LibraryManagementSystem.DTO.Respsonse.StudentResponse;
import com.example.LibraryManagementSystem.model.Student;
import com.example.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){

        StudentResponse response = studentService.addStudent(studentRequest);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-student")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){

        Student response = studentService.getStudent(regNo);

        if(response!=null) return new ResponseEntity(response,HttpStatus.FOUND);

        return new ResponseEntity<>("Invalid ID !!",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete-student")
    public ResponseEntity deleteStudent(@RequestParam("id") int regNo){

        String response = studentService.deleteStudent(regNo);

        if (response!=null){
            return  new ResponseEntity("Student deleted successfully",HttpStatus.ACCEPTED);
        }

        return new ResponseEntity("Student Not Found", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PutMapping("/update-age")
    public ResponseEntity updateAge(@RequestParam("id") int regNo , @RequestParam("age") int age){

        Student response = studentService.updateAge(regNo,age);

        if(response!=null){

            return new ResponseEntity<>("updated!!",HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity getAllStudent(){

        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return new ResponseEntity<>("NO student added",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studentList,HttpStatus.FOUND);


    }


    @GetMapping("/getMaleStudent")
    public ResponseEntity getMaleStudent(){

        List<Student> studentList = studentService.getMaleStudent();

        if(studentList.isEmpty()){
            return new ResponseEntity<>("NO male student added",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studentList,HttpStatus.FOUND);


    }



}
