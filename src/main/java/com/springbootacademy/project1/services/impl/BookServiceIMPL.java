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

    @Override
    public String saveBook(BookDTO bookDTO) {
        Books books = modelMapper.map(bookDTO,Books.class);
        bookRepo.save(books);
        return "Saved";

    }
}
