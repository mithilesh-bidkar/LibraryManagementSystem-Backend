package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String transactionId;//by uuid..

    @CreationTimestamp
    Date date;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Book book;


    //transaction and Library card..

    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;

}
