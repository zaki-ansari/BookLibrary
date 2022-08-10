package com.masai.service;

import java.util.List;

import com.masai.exception.BookNotFoundException;
import com.masai.module.Book;


public interface BookService {
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book)throws BookNotFoundException;
	
	public Book removeBook(Integer bookId)throws BookNotFoundException;
	
	public Book viewBook(Integer bookId)throws BookNotFoundException;
	
	public List<Book> viewAllBooks()throws BookNotFoundException;

}
