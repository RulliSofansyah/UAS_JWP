package com.bookstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

// Rulli Sofansyah 2112500224
// Gerry Bagus Sadewo 2112500067
// UAS Java Web Programming 

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book b){
        bRepo.save(b);    
    }
    public List<Book> getAllBook(){
        return bRepo.findAll();
    }
        
    public Book getBookById(int id){
        return bRepo.findById(id).get();
    }
    public void deleteById(int id){
        bRepo.deleteById(id);
    }
}
