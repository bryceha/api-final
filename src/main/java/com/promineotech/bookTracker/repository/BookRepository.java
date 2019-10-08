package com.promineotech.bookTracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bookTracker.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
