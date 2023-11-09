package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.DTOs.Request.AddAuthorRequestDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.AuthorResponseDto;
import com.example.LibraryManagementSystem.models.Author;

import java.util.ArrayList;

public class AuthorTransformer
{

    public static Author AuthorFromAddAuthorRequestDto(AddAuthorRequestDto addAuthorRequestDto){
        return Author.builder()
                .age(addAuthorRequestDto.getAge())
                .emailId(addAuthorRequestDto.getEmail())
                .gender(addAuthorRequestDto.getGender())
                .name(addAuthorRequestDto.getName())
                .books(new ArrayList<>())
                .build();
    }

    public static AuthorResponseDto AuthorToAuthorResponceDto(Author author)
    {
        return AuthorResponseDto.builder()
                .age(author.getAge())
                .email(author.getEmailId())
                .name(author.getName())
                .gender(author.getGender())
                .lastActivity(author.getLastActivity())
                .build();
    }
}
