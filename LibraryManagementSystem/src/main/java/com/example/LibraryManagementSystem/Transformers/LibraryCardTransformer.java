package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.enums.CardStatus;
import com.example.LibraryManagementSystem.models.LibraryCard;
import com.example.LibraryManagementSystem.models.Student;

import java.util.UUID;

public class LibraryCardTransformer
{
    public  static LibraryCard GenerateLibraryCardForStudent(Student student)
    {
        return LibraryCard.builder()
                .student(student)
                .cardId(UUID.randomUUID().toString())
                .cardStatus(CardStatus.Active)
                .build();

    }
}
