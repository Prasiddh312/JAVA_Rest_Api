package com.restapi.CrudExample3.service;

import com.restapi.CrudExample3.entity.Books;
import com.restapi.CrudExample3.repositroy.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    public BookRepository repository;

    /**************POST**********************/

    public Books saveBook(Books book){
        return repository.save(book);
    }

    public List<Books> saveBooks(List<Books> books){
        return repository.saveAll(books);
    }

    /***************GET*********************/

    public List<Books> getBooks(){
        return repository.findAll();
    }

    public Books getBookById(int id){
    return repository.findById(id).orElse(null);
    }

    public Books getBookByName(String name){
        return repository.findByName(name);
    }
    /************DELETE***************************/

    public String deleteBook(int id){
        repository.deleteById(id);
        return "Item Removed!!"+id;
    }

    /**********UPDATE************************/

    public Books UpdateBook(Books book){
    Books existingBook=repository.findById(book.getId()).orElse(null);
    existingBook.setName(book.getName());
    existingBook.setAuthor(book.getAuthor());
    return repository.save(existingBook);
    }
}
