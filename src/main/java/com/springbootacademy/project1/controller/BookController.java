package com.springbootacademy.project1.controller;

import com.springbootacademy.project1.DTO.BookDTO;
import com.springbootacademy.project1.DTO.response.BookGetResponseDTO;
import com.springbootacademy.project1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    //Dependancy Injection
    @Autowired
    private BookService bookService;


    //save Book
    @PostMapping("/save")
    public String saveBook(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO);
        return "Book Saved";
    }

    //Search book by ID
    @GetMapping(path = "/get-book-by-id", params = "id")
    public BookDTO searchBook(@RequestParam(value = "id") int bookId){
        return bookService.searchBook(bookId);
    }

    //delete Book on ID
    @DeleteMapping(path = "/delete", params = "id")
    public String deleteBook(@RequestParam(value = "id") int bookId){
        String delete = bookService.deleteBook(bookId);
        return "Book Deleted";
    }

    //get all books
    @GetMapping(path = "/get-all-books")
    public List<BookDTO> getAllBooks(){
        List<BookDTO> allBooks = bookService.getAllBooks();
        return  allBooks;
    }

    //get book by active status and book price
    @GetMapping(path = "/get-book-by-active-status-and-price", params = {"status","price"})
    public List<BookGetResponseDTO> getBookByActiveStatusAndPrice(
            @RequestParam(value = "status") boolean status,
            @RequestParam(value = "price") double price){
        List<BookGetResponseDTO> bookGetResponseDTO = bookService.getBookByActiveStatusAndPrice(status,price);
        return bookGetResponseDTO;
    }

}
