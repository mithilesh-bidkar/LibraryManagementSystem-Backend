package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.DTOs.Request.AddBookRequestDTO;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;
import com.example.LibraryManagementSystem.enums.Genre;

import java.util.List;
import java.util.Set;

public interface BookService
{
    public BookResponseDto addBook(AddBookRequestDTO addBookRequestDTO);
    public String deleteBook(Integer bookId);

    public List<BookResponseDto> getBooksByGenre(Genre genre);

    public List<BookResponseDto> findAllBooksBetweenAandB(Integer a, Integer b);
    public List<BookResponseDto> getBooksByGenreAndMoreThanCost(Genre genre, Integer cost);

    public Set<String> getAllAuthorsByGenre(Genre genre);
}
