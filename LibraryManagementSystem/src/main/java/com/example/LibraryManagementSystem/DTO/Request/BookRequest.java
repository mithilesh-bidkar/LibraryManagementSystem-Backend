package com.example.LibraryManagementSystem.DTO.Request;


import com.example.LibraryManagementSystem.Enums.Genere;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {

    String title;

    int noOfPages;

    Genere genere;

    Double cost;
}
