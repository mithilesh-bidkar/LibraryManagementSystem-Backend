package com.example.LibraryManagementSystem.DTOs.ResponseDTO;

import com.example.LibraryManagementSystem.enums.Department;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponseDto
{
    int reg;
    String name;
    Department department;
    String email;

    String libraryCardId; //this will be uuid..

}
