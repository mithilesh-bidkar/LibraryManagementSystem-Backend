package com.example.LibraryManagementSystem.services.impl;

import com.example.LibraryManagementSystem.CustomException.AuthorRelatedException.AuthorNotFoundException;
import com.example.LibraryManagementSystem.CustomException.BookRelatedException.BookNotFoundException;
import com.example.LibraryManagementSystem.DTOs.Request.AddBookRequestDTO;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;
import com.example.LibraryManagementSystem.Transformers.BookTransformer;
import com.example.LibraryManagementSystem.enums.Genre;
import com.example.LibraryManagementSystem.models.Author;
import com.example.LibraryManagementSystem.models.Book;
import com.example.LibraryManagementSystem.repositories.AuthorRepository;
import com.example.LibraryManagementSystem.repositories.BookRepository;
import com.example.LibraryManagementSystem.services.BookService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BookServiceImpl   implements BookService
{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public BookResponseDto addBook (AddBookRequestDTO addBookRequestDTO)
    {
        Optional<Author>optional=authorRepository.findById(addBookRequestDTO.getAuthorId());

        if(optional.isEmpty())throw new AuthorNotFoundException("Author Not Found!!");
            Author author=optional.get();

            Book book= BookTransformer.AddBookRequestDtoToBook(addBookRequestDTO);
            book.setAuthor(author);

        author.getBooks().add(book);
        //save the author
       author = authorRepository.save(author);

        log.info("Book Added successFuyll!!");
       BookResponseDto bookResponseDto =BookTransformer.BookToBookResponceDto(book);

        return bookResponseDto;
    }

    @Override
    public String deleteBook(Integer bookId)
    {
        Optional<Book>optional=bookRepository.findById(bookId);
        if(!optional.isPresent())throw new BookNotFoundException("Book did not Found");

        Book book=optional.get();
        Author author=book.getAuthor();

        List<Book> bookList=author.getBooks();
        bookList.remove(book);

        bookRepository.deleteById(bookId);

        authorRepository.save(author);

        return "Book has Been Deleted Successfully From the Database!!";
    }
    @Override
    public List<BookResponseDto> getBooksByGenre(Genre genre)
    {
        List<Book>books=bookRepository.findByGenre(genre);

        List<BookResponseDto>names=new ArrayList<>();

        for (Book book:books){
            BookResponseDto bookResponseDto =BookTransformer.BookToBookResponceDto(book);
            names.add(bookResponseDto);
        }
        return names;
    }
    @Override
    public List<BookResponseDto> getBooksByGenreAndMoreThanCost(Genre genre, Integer cost)
    {
        List<Book>books=bookRepository.findByGenreAndCost(genre.toString(),cost);

        List<BookResponseDto>names=new ArrayList<>();

        for (Book book:books)
        {
            if(book.getCost() > cost)
            {
               BookResponseDto bookResponseDto =BookTransformer.BookToBookResponceDto(book);
               names.add(bookResponseDto);
            }
        }
        return names;
    }

    @Override
    public List<BookResponseDto> findAllBooksBetweenAandB(Integer a, Integer b)
    {
        List<Book>bookList=bookRepository.findAllBooksNoOfPagesBetweenAandB(a,b);

        List<BookResponseDto>books=new ArrayList<>();
        for(Book book:bookList)
        {
            int noOfPages= book.getNoOfPages();
            if(noOfPages>a && noOfPages<b)
            {
                BookResponseDto dto=BookTransformer.BookToBookResponceDto(book);
                books.add(dto);
            }
        }
        if(books.isEmpty()) log.warn("There Are No books Availble");
        return books;
    }
    @Override
    public Set<String> getAllAuthorsByGenre(Genre genre)
    {
        List<Book>bookList=bookRepository.findByGenre(genre);


       Set<String> collection= new HashSet<>();
        for(Book book:bookList)
        {
           if(!collection.contains(book.getAuthor().getName())) collection.add(book.getAuthor().getName());
        }
        return collection;
    }
}
