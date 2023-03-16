package com.springbootacademy.project1.services;

import com.springbootacademy.project1.DTO.BookDTO;
import com.springbootacademy.project1.DTO.response.BookGetResponseDTO;

import java.util.List;

public interface BookService {
    String saveBook(BookDTO bookDTO);

    BookDTO searchBook(int bookId);

    String deleteBook(int bookId);

    List<BookGetResponseDTO> getBookByActiveStatusAndPrice(boolean status, double price);

    List<BookDTO> getAllBooks();
}
