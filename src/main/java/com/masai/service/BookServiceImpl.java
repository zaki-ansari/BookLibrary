package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookNotFoundException;
import com.masai.module.Book;
import com.masai.repository.BookDao;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bDao;
	
	@Override
	public Book addBook(Book book) {
		
		return bDao.save(book);
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {
		

		Optional<Book> opt = bDao.findById(book.getbookId());
		
		if(opt.isPresent()) {
			
			Book existingBook = opt.get();
			
			return bDao.save(book);
		}
		else {
			throw new BookNotFoundException("Invalid Book Details...");
		}
	}

	@Override
	public Book removeBook(Integer bookId) throws BookNotFoundException {
		
		Book existingBook =  bDao.findById(bookId).orElseThrow(()-> new BookNotFoundException("Book does not exist with Roll "+bookId));
		
		bDao.delete(existingBook);
		
		return existingBook;
	}

	@Override
	public Book viewBook(Integer bookId) throws BookNotFoundException {
		
		return bDao.findById(bookId).orElseThrow(()-> new BookNotFoundException("Book does not exist with Roll "+bookId));
	}

	@Override
	public List<Book> viewAllBooks() throws BookNotFoundException {
		
	List<Book> books = bDao.findAll();
		
		if(books.size() > 0)
			return books;
		else
			throw new BookNotFoundException("No Book found...");
		}
	
	
	

}
