package com.example.LibraryManagementSystem.DTOs.ResponseDTO;

import com.example.LibraryManagementSystem.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDto
{
    String title;
    int noOfPages;
    Genre genre;
    double cost;
    String authorName;
}
