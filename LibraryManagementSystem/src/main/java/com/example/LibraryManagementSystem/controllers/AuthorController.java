package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.DTOs.Request.AddAuthorRequestDto;
import com.example.LibraryManagementSystem.DTOs.Request.UpdateEmailDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.AuthorResponseDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;
import com.example.LibraryManagementSystem.services.AuthorService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/author")
@Slf4j
public class AuthorController
{
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AddAuthorRequestDto addAuthorRequestDto)
    {
      AuthorResponseDto author= authorService.addAuthor(addAuthorRequestDto);

        return new ResponseEntity(author, HttpStatus.CREATED);
    }


    // update the email id of an author  -->> observer lastActivity column
    @PutMapping("/email")
    public ResponseEntity updateEmail(@RequestBody UpdateEmailDto updateEmailDto)
    {
        try
        {
            AuthorResponseDto responceDto= authorService.updateEmail(updateEmailDto);
            return new ResponseEntity<>(responceDto,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
           log.error("There is some issue"+e.getMessage(),e.getMessage());
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/books-by-author")
    public ResponseEntity booksByAuthor(@RequestParam Integer authorId)
    {
        try
        {
            List<BookResponseDto>books= authorService.findBooksByAuthor(authorId);
            return new ResponseEntity<>(books,HttpStatus.ACCEPTED);
        }catch (Exception e)
        {
            log.error(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    // give me the names of authors who have written more than 'x' number of books

    @GetMapping("/author-Written/{x}")
    public ResponseEntity getAllAuthorsHaveWrittenMoreThanXBooks(@PathVariable("x") Integer x)
    {
        List<AuthorResponseDto>authors= authorService.getAllAuthorsHaveWrittenMoreThanXBooks(x);
        return new ResponseEntity(authors,HttpStatus.ACCEPTED);
    }



}
