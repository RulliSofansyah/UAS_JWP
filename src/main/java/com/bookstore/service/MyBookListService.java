package com.bookstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

// Rulli Sofansyah 2112500224
// Gerry Bagus Sadewo 2112500067
// UAS Java Web Programming 

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository mybook;
    
    public void saveMyBooks(MyBookList book) {
        mybook.save(book);
    }
    public List<MyBookList> getAllMyBooks(){
        return mybook.findAll();
    }
    public void deleteById(int id) {
    	mybook.deleteById(id);
    }
}

// Rulli Sofansyah 2112500224
// Gerry Bagus Sadewo 2112500067
// UAS Java Web Programming 