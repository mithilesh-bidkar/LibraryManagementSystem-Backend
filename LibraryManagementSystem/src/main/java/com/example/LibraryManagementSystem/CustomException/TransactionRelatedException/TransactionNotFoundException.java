package com.example.LibraryManagementSystem.CustomException.TransactionRelatedException;

public class TransactionNotFoundException extends  RuntimeException{
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
