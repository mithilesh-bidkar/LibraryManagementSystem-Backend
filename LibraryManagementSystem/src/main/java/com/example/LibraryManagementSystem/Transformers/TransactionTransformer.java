package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.enums.TransactionStatus;
import com.example.LibraryManagementSystem.models.Book;
import com.example.LibraryManagementSystem.models.Student;
import com.example.LibraryManagementSystem.models.Transaction;

import java.util.UUID;

public class TransactionTransformer
{
    public static Transaction generateTransaction(Student student, Book book)
    {
        return Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.Success)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();
    }
}
