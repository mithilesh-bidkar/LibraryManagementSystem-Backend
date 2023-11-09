package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.DTOs.Request.AddBookRequestDTO;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.IssueBookResponse;
import com.example.LibraryManagementSystem.models.Book;
import com.example.LibraryManagementSystem.models.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookTransformer
{
    public static BookResponseDto BookToBookResponceDto(Book book)
    {
    return BookResponseDto.builder()
            .authorName(book.getAuthor().getName())
            .cost(book.getCost())
            .genre(book.getGenre())
            .title(book.getTitle())
            .noOfPages(book.getNoOfPages())
            .build();
    }

    public static Book AddBookRequestDtoToBook(AddBookRequestDTO addBookRequestDTO)
    {
        return  Book.builder()
                .genre(addBookRequestDTO.getGenre())
                .title(addBookRequestDTO.getTitle())
                .cost(addBookRequestDTO.getPrice())
                .dateOfPublication(addBookRequestDTO.getDataOfPublication())
                .noOfPages(addBookRequestDTO.getNoOfPage())
                .issued(!addBookRequestDTO.isAvailable())
                .build();
    }

    public static IssueBookResponse IssueBookResponceFromBookAndStudent(Student student, Book book)
    {
        return IssueBookResponse.builder()
                .bookName(book.getTitle())
                .studentName(student.getName())
                .libraryCardNumber(student.getLibraryCard().getCardId())
                .authorName(book.getAuthor().getName())
                .build();
    }
}
