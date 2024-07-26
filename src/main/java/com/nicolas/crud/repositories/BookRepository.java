package com.nicolas.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.crud.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
}
