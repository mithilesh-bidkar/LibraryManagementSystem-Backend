package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    @Autowired
    BookRespository bookRespository;
}
