package com.example.LibraryManagementSystem.DTOs.Request;

import com.example.LibraryManagementSystem.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddAuthorRequestDto
{
    String name;
    int age;
    String email;
    Gender gender;
}
