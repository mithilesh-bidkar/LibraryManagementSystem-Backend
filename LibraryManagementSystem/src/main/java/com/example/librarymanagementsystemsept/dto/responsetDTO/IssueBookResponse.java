package com.example.librarymanagementsystemsept.dto.responsetDTO;

import com.example.librarymanagementsystemsept.Enum.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class IssueBookResponse {

    String transactionNumber;

    Date transactionTime;

    TransactionStatus transactionStatus;

    String bookName;

    String authorName;

    String studentName;

    String libraryCardNumber;
}
