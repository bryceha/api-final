package com.promineotech.bookTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bookTracker.entity.Book;
import com.promineotech.bookTracker.service.BookService;

@RestController
@RequestMapping("users/{id}/books")
public class BookController {

	@Autowired
	private BookService service;
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getBook(@RequestBody Long bookId) {
		try {
			return new ResponseEntity<Object>(service.getBookById(bookId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getBooks() {
		return new ResponseEntity<Object>(service.getBooks(), HttpStatus.OK);                                                                                             
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> addBook(@RequestBody Book book, @PathVariable Long id) throws Exception {
		return new ResponseEntity<Object>(service.addBook(book, id), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable Long bookId) {
		try {
			return new ResponseEntity<Object>(service.updateBook(book, bookId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> removeBook(@PathVariable Long id) {
		try {
			service.removeBook(id);
			return new ResponseEntity<Object>("Successfully removed book with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
