package com.restapi.CrudExample3.controller;

import com.restapi.CrudExample3.entity.Books;
import com.restapi.CrudExample3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {
    @Autowired
    public BookService service;

    /**********POST API*********************/
@PostMapping("/addBook")
    public Books addBook(@RequestBody Books book){
        return service.saveBook(book);
    }
    @PostMapping("/addBooks")
    public List<Books> addBooks(@RequestBody List<Books> book){
    return service.saveBooks(book);
    }
    /*******************GET API****************/
    @GetMapping("/allBooks")
    public ResponseEntity <List<Books>> findAllBooks(){ //Sending Response From API
        List<Books> list=service.getBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/bookById/{id}")
    public  ResponseEntity<Books> findBookById(@PathVariable("id") int id){

        Books book=service.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
    @GetMapping("bookByName/{name}")
    public ResponseEntity<Books> findBookByName(@PathVariable("name") String name){
        Books book=service.getBookByName(name);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
/**********************PUT API**********************************/
@PutMapping("/update")
public Books updateBook(@RequestBody Books book){
    return service.UpdateBook(book);
}
/******************DELETE API*************************/

@DeleteMapping("/delete/{id}")
public String deleteBook(@PathVariable int id) {


    return service.deleteBook(id);
}
}
