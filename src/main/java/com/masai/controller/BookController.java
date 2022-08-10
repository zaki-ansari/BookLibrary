package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.module.Book;
import com.masai.service.BookService;


@RestController
public class BookController {
	
	@Autowired
	private BookService bService;
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBookHandler(@RequestBody Book book){
		
		Book savedBook = bService.addBook(book);
		
		return new ResponseEntity<Book>(savedBook,HttpStatus.CREATED);
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBookById(@PathVariable("bookId") Integer bookId) {
		return bService.viewBook(bookId);
	}
	
	
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookDetails(){
		
		List<Book> Books = bService.viewAllBooks();
		
		return new ResponseEntity<List<Book>>(Books, HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{bookId}")
	public Book deleteBookById(@PathVariable("bookId") Integer bookId) {
		return bService.removeBook(bookId);
	}
	
	@PutMapping("/books")
	public ResponseEntity<Book> updateStudentHandler(@RequestBody Book book){
		
		Book updatedBook = bService.updateBook(book);
		
		return new ResponseEntity<Book>(updatedBook, HttpStatus.ACCEPTED);
	}
}
