package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.MyBookListService;

// Rulli Sofansyah 2112500224
// Gerry Bagus Sadewo 2112500067
// UAS Java Web Programming 

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookListService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/my_books";
	}

}
