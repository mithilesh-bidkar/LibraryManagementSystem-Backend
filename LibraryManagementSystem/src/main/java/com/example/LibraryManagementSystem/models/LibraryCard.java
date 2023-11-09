package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cardId; //this will be UUID.. you'll have to write the logic for it..

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreationTimestamp
    Date date;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();
}
