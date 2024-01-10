package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.MyBookList;

// Rulli Sofansyah 2112500224
// Gerry Bagus Sadewo 2112500067
// UAS Java Web Programming 

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Integer>{
    
}
