package com.springbootacademy.project1.services.impl;

import com.springbootacademy.project1.DTO.BookDTO;
import com.springbootacademy.project1.DTO.response.BookGetResponseDTO;
import com.springbootacademy.project1.entity.Books;
import com.springbootacademy.project1.repo.BookRepo;
import com.springbootacademy.project1.services.BookService;
import com.springbootacademy.project1.util.BookMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookMapper bookMapper;

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

    //View all books
    @Override
    public List<BookDTO> getAllBooks(){
        List<Books> books = bookRepo.findAll();
        if (books.size()>0){
            List<BookDTO> getAllBooks = bookMapper.entityListToDTOList(books);
            return getAllBooks;
        }
        else {
            throw new RuntimeException("No Books Found");
        }

    }


    //get book by active status and book price
    @Override
    public List<BookGetResponseDTO> getBookByActiveStatusAndPrice(boolean status, double price) {
        List<Books> books = bookRepo.findAllByActiveStatusAndBookValue(status,price);
        if (books.size()>0){
            List<BookGetResponseDTO> bookGetResponseDTO = modelMapper.map(books,new TypeToken<List<BookGetResponseDTO>>(){}.getType());
        return  bookGetResponseDTO;
        }
        else {
            throw new RuntimeException("No Book Exist");
        }
    }


}

