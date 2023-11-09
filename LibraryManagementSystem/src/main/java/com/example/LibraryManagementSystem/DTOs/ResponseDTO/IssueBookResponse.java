package com.example.LibraryManagementSystem.DTOs.ResponseDTO;

import com.example.LibraryManagementSystem.enums.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IssueBookResponse
{
    String transactionNumber;
    Date transactionTime;

    TransactionStatus transactionStatus;

    String bookName;
    String authorName;
    String studentName;

    String libraryCardNumber;
}
