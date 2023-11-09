package com.example.LibraryManagementSystem.DTOs.ResponseDTO;

import com.example.LibraryManagementSystem.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponseDto
{
    String name;
    int age;
    String email;
    Date lastActivity;
    Gender gender;
}
