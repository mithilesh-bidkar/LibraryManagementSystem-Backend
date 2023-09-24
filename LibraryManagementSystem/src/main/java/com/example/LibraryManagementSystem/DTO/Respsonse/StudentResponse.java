package com.example.LibraryManagementSystem.DTO.Respsonse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponse {

    String name;

    String email;

    String libraryCardIssuedNo;

    String message;
}
