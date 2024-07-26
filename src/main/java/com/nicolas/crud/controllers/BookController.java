package com.nicolas.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.crud.entities.Book;
import com.nicolas.crud.services.BooksServiceImpl;

@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:4200/")
public class BookController {

	@Autowired
	BooksServiceImpl bookServiceImpl;
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		try {
			Book savedBook = bookServiceImpl.saveBook(book);
			return new ResponseEntity<>(savedBook, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		try {
			Book savedBook = bookServiceImpl.saveBook(book);
			return new ResponseEntity<>(savedBook, HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<>(bookServiceImpl.getBooks(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		Optional<Book> book = bookServiceImpl.getBookById(id);
		if (book.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(book.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		Optional<Book> book = bookServiceImpl.getBookById(id);
		if (book.isPresent()) {
			bookServiceImpl.deleteBook(book.get().getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
