package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.module.Book;
import com.masai.module.Reader;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{
	
	@Query("select new com.masai.module.Reader(b.name,b.author,b.publication,b.category,b.pages,b.price) from Book b where b.bookId=:bookId")        
	public Reader getBookById(@Param("bookId") Integer bookId);
	
	@Query("select new com.masai.module.Reader(b.name,b.author,b.publication,b.category,b.pages,b.price) from Book b")        
	public List<Reader> getAllBooks();

}
