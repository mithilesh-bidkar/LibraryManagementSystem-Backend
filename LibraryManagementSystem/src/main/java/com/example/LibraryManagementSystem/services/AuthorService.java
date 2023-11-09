package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.DTOs.Request.AddAuthorRequestDto;
import com.example.LibraryManagementSystem.DTOs.Request.UpdateEmailDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.AuthorResponseDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;

import java.util.List;

public interface AuthorService
{
    public AuthorResponseDto addAuthor(AddAuthorRequestDto addAuthorRequestDto);
    public AuthorResponseDto updateEmail(UpdateEmailDto updateEmailDto);
    public List<BookResponseDto> findBooksByAuthor(Integer authorId);
    public List<AuthorResponseDto> getAllAuthorsHaveWrittenMoreThanXBooks(Integer x);
}
