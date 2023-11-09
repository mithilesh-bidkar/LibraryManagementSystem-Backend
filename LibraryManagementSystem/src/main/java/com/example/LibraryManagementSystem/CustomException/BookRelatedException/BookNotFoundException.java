package com.example.LibraryManagementSystem.CustomException.BookRelatedException;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message)
    {
        super(message);
    }
}
