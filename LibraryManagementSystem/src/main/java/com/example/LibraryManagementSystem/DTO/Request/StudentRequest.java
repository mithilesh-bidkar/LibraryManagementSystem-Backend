package com.example.LibraryManagementSystem.DTO.Request;


import com.example.LibraryManagementSystem.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentRequest {

    String name;

    int age;

    String email;

    Gender gender;
}
