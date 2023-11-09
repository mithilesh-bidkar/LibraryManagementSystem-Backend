package com.example.LibraryManagementSystem.controllers;


import com.example.LibraryManagementSystem.DTOs.Request.AddStudentDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.StudentResponseDto;
import com.example.LibraryManagementSystem.enums.Department;
import com.example.LibraryManagementSystem.enums.Gender;
import com.example.LibraryManagementSystem.services.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentController
{
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent (@RequestBody AddStudentDto student)
    {
        try
        {
            StudentResponseDto resp = studentService.addStudent(student);
            return new ResponseEntity<>(resp,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            log.error("Student not add (){}"+e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/get-dept-by-id")
    public ResponseEntity<Department> getDepByID(@RequestParam("id") Integer id)
    {
        try
        {
            Department department= studentService.getDeptById(id);
            return new ResponseEntity<>(department,HttpStatus.OK);
        }
        catch(Exception e)
        {
            log.error("Not getting the Department{}"+e.getMessage());
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }

    //delete a student.. regNo..

    //list of All male students..

    //update age.. of student..

    //get all the students..

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("regNo") Integer regNo)
    {
        try
        {
            String ans= studentService.deleteStudent(regNo);
            return new ResponseEntity(ans,HttpStatus.FORBIDDEN);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update-age")
    public ResponseEntity updateAge(@RequestParam int age,@RequestParam int regNo)
    {
        try
        {
            StudentResponseDto student= studentService.updateAge(age,regNo);

            log.info("You Have Successfully Updated the age of Student");
            return new ResponseEntity(student,HttpStatus.ACCEPTED);
        }catch (Exception e){
            log.error("There was something ");

            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-all-by-gender")
    public ResponseEntity getAllMaleStudents(@RequestParam Gender gender){
        try{

            List<StudentResponseDto>students= studentService.getAllMaleStudents(gender);
            log.info("You have the Student list");
            return new ResponseEntity(students,HttpStatus.OK);

        }catch (Exception e){
            log.error("Unable to proceed your request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity getAllStudents()
    {
        try
        {
            List<StudentResponseDto>students= studentService.getAllStudents();
            log.info("You have the Student list");
            return new ResponseEntity(students,HttpStatus.OK);

        }catch (Exception e)
        {
            log.error("Unable to proceed your request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
