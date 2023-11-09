package com.example.LibraryManagementSystem.services.impl;

import com.example.LibraryManagementSystem.CustomException.AuthorRelatedException.AuthorNotFoundException;
import com.example.LibraryManagementSystem.DTOs.Request.AddAuthorRequestDto;
import com.example.LibraryManagementSystem.DTOs.Request.UpdateEmailDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.AuthorResponseDto;
import com.example.LibraryManagementSystem.DTOs.ResponseDTO.BookResponseDto;
import com.example.LibraryManagementSystem.Transformers.AuthorTransformer;
import com.example.LibraryManagementSystem.Transformers.BookTransformer;
import com.example.LibraryManagementSystem.models.Author;
import com.example.LibraryManagementSystem.models.Book;
import com.example.LibraryManagementSystem.repositories.AuthorRepository;
import com.example.LibraryManagementSystem.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorRepository;
    public AuthorResponseDto addAuthor(AddAuthorRequestDto addAuthorRequestDto)
    {
        //just Transform into Author
        Author author= AuthorTransformer.AuthorFromAddAuthorRequestDto(addAuthorRequestDto);

        Author savedAuthor= authorRepository.save(author);

        AuthorResponseDto responceDto=AuthorTransformer.AuthorToAuthorResponceDto(savedAuthor);

        return responceDto;
    }

    public AuthorResponseDto updateEmail(UpdateEmailDto updateEmailDto)
    {
        Optional<Author>optional=authorRepository.findById(updateEmailDto.getAuthorId());
        if(optional.isPresent()==false)
        {
            log.error("Author with author Id"+updateEmailDto.getAuthorId()+" Not Found!!");
            throw new AuthorNotFoundException("Author Not Found!!");
        }

        Author author=optional.get();

        author.setEmailId(updateEmailDto.getEmail());

       author= authorRepository.save(author);

       AuthorResponseDto authorResponseDto =AuthorTransformer.AuthorToAuthorResponceDto(author);

        return authorResponseDto;
    }

    public List<BookResponseDto> findBooksByAuthor(Integer authorId)
    {
        Optional<Author>optional=authorRepository.findById(authorId);
        if(optional.isPresent()==false)
        {
            log.error("Author with author Id"+authorId+" Not Found!!");
            throw new AuthorNotFoundException("Author Not Found!!");
        }

        Author author=optional.get();
       //you have to do everything here it self..

        List<BookResponseDto>books=new ArrayList<>();
        for(Book book:author.getBooks())
        {
            BookResponseDto bookResponseDto = BookTransformer.BookToBookResponceDto(book);

            //addition of the answerList..
            books.add(bookResponseDto);
        }
        return books;
    }

    public List<AuthorResponseDto> getAllAuthorsHaveWrittenMoreThanXBooks(Integer x)
    {
        List<Author>authorList=authorRepository.findAll();

        List<AuthorResponseDto>authors=new ArrayList<>();
        for(Author author:authorList){
            if(author.getBooks().size()>x)
            {
               AuthorResponseDto authorResponseDto =AuthorTransformer.AuthorToAuthorResponceDto(author);

               //adding of the answer
               authors.add(authorResponseDto);
            }
        }


        return authors;
    }
}
