package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.module.Reader;
import com.masai.service.BookService;

@RestController
public class ReaderController {

	@Autowired
	private BookService bservice;
	
	@GetMapping("/reader/{bookId}")
	public Reader getBookById(@PathVariable("bookId") Integer bookId) {
		return bservice.getBook(bookId);
	}
	@GetMapping("/reader")
	public List<Reader> getAllBooks(){
		return bservice.getAllBooksReader();
		
	}
}
