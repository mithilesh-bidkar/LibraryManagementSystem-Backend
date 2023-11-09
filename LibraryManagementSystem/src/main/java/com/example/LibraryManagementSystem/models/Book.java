package com.example.LibraryManagementSystem.models;

import com.example.LibraryManagementSystem.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    int noOfPages;
    @Enumerated(EnumType.STRING)
    Genre genre;

    double cost;

    LocalDate dateOfPublication;

    boolean issued;

    @ManyToOne
    @JoinColumn
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction>transactions=new ArrayList<>();
}
