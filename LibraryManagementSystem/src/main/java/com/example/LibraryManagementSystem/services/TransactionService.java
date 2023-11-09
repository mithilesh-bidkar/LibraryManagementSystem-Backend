package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.DTOs.ResponseDTO.IssueBookResponse;

public interface TransactionService
{
    public IssueBookResponse issueBook(Integer bookId, Integer studentId);

   public IssueBookResponse returnBook(Integer studentId, Integer bookId);
}
