package com.springbootacademy.project1.services;

import com.springbootacademy.project1.DTO.BookDTO;

public interface BookService {
    String saveBook(BookDTO bookDTO);

    BookDTO searchBook(int bookId);

    String deleteBook(int bookId);
}
