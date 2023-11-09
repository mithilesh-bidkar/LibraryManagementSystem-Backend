package com.example.LibraryManagementSystem.controllers;

import com.example.LibraryManagementSystem.DTOs.Request.AddBookRequestDTO;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;
import com.example.LibraryManagementSystem.enums.Genre;
import com.example.LibraryManagementSystem.services.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/book")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BookController
{
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody AddBookRequestDTO addBookRequestDTO)
    {
        BookResponseDto responce= bookService.addBook(addBookRequestDTO);

        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    // delete a book

    @DeleteMapping("/delete")
    public ResponseEntity deleteBookById(@RequestParam Integer bookId)
    {
       try
       {
           String res= bookService.deleteBook(bookId);
           return new ResponseEntity(res,HttpStatus.ACCEPTED);
       }
       catch (Exception e){
           log.error("There is Some error"+e.getMessage());

           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    // give me names of all the books of a particular genre

    @GetMapping("/get-books-by-genre")
    public List<BookResponseDto> getBooksByGenre(@RequestParam Genre genre)
    {
        List<BookResponseDto>books= bookService.getBooksByGenre(genre);
        return books;
    }

    // give me names of all the books of a particular genre and cost gretaer than 500 rs

    @GetMapping("/get-books-by-genre-and-more-than/{cost}")
    public List<BookResponseDto>getBooksByGenreAndMoreThanCost(@RequestParam Genre genre, @PathVariable("cost") Integer cost){
        List<BookResponseDto>ans= bookService.getBooksByGenreAndMoreThanCost(genre,cost);
        return ans;
    }

    // give me all the books having number of pages between 'a' and 'b'

    @GetMapping("/get-all-books-having-pages-between")
    public List<BookResponseDto>findAllBooksBetweenAandB(@RequestParam Integer a, @RequestParam Integer b)
    {
        return  bookService.findAllBooksBetweenAandB(a,b);
    }

    // give me the names of all the authors who write a particular genre

    @GetMapping("/get-all-authors-by-genre")
    public Collection getAllAuthorsByGenre(@RequestParam Genre genre)
    {
        return bookService.getAllAuthorsByGenre(genre);
    }

}
