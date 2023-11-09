package com.example.LibraryManagementSystem.CustomException.BookRelatedException;

public class BookIsNotAvailableException extends RuntimeException{
    public BookIsNotAvailableException(String message) {
        super(message);
    }
}
