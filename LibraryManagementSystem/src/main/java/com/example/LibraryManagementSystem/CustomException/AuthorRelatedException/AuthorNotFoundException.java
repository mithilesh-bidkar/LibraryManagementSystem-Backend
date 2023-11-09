package com.example.LibraryManagementSystem.CustomException.AuthorRelatedException;

public class AuthorNotFoundException extends RuntimeException
{
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
