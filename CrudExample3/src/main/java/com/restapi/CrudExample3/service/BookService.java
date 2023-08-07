package com.restapi.CrudExample3.service;

import com.restapi.CrudExample3.entity.Books;

import java.util.List;

public interface BookService {
    public Books saveBook(Books book);
    public List<Books> saveBooks(List<Books> books);
    public List<Books> getBooks();
    public Books getBookById(int id);
    public Books getBookByName(String name);
    public String deleteBook(int id);
    public Books UpdateBook(Books book);

}
