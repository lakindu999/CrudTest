package com.springbootacademy.project1.services.impl;

import com.springbootacademy.project1.DTO.BookDTO;
import com.springbootacademy.project1.entity.Books;
import com.springbootacademy.project1.repo.BookRepo;
import com.springbootacademy.project1.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;


    //save Book
    @Override
    public String saveBook(BookDTO bookDTO) {
        Books books = modelMapper.map(bookDTO, Books.class);
        bookRepo.save(books);
        return "Saved";

    }

    //search Book
    @Override
    public BookDTO searchBook(int bookId) {
        if (bookRepo.existsById(bookId)) {
            Books books = bookRepo.getReferenceById(bookId);
            BookDTO bookDTO = modelMapper.map(books, BookDTO.class);

            return bookDTO;
        }

        else {
            throw new RuntimeException("No Book Exist");
        }

    }

    //Delete Book
    @Override
    public String deleteBook(int bookId) {
        if (bookRepo.existsById(bookId)){
            bookRepo.deleteById(bookId);
            return "Successfully Deleted";
        }
        else {
            throw new RuntimeException("No Book Exist");
        }

    }
}

