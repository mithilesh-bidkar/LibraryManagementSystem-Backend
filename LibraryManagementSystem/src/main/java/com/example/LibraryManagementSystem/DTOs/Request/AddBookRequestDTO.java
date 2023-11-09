package com.example.LibraryManagementSystem.DTOs.Request;

import com.example.LibraryManagementSystem.enums.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddBookRequestDTO
{
     String title;
     boolean isAvailable;
     Genre genre;
     LocalDate dataOfPublication;
     Integer authorId;
     Integer price;
     Integer noOfPage;
}
