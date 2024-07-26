package com.nicolas.crud.services;

import java.util.List;
import java.util.Optional;

import com.nicolas.crud.entities.Book;

public interface BookService {

	Book saveBook (Book book);
		
	Book updateBook(Book book);
			
	List<Book>getBooks();
		
	Optional<Book>getBookById(Long id);
		
	void deleteBook(Long id);
}
