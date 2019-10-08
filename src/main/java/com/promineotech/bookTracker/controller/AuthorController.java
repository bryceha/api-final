package com.promineotech.bookTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bookTracker.entity.Author;
import com.promineotech.bookTracker.service.AuthorService;
//import com.promineotech.bookTracker.service.BookService;

@RestController
@RequestMapping("users/{id}/authors")
public class AuthorController {

	@Autowired
	private AuthorService service;
	
//	private BookService bookService;
	
	@RequestMapping(value = "/{authorId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAuthor(@PathVariable Long authorId) {
		try {
			return new ResponseEntity<Object>(service.getAuthorById(authorId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAuthors() {
		return new ResponseEntity<Object>(service.getAuthors(), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/{authorId}/books")
//	public ResponseEntity<Object> getBooks(){
//		return new ResponseEntity<Object>(bookService.getBooks(), HttpStatus.OK);
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addAuthor(@RequestBody Author author) {
		return new ResponseEntity<Object>(service.addAuthor(author), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{authorId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAuthor(@RequestBody Author author, @PathVariable Long authorId) {
		try {
			return new ResponseEntity<Object>(service.updateAuthor(author, authorId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{authorId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removeAuthor(@PathVariable Long authorId) {
		try {
			service.removeAuthor(authorId);
			return new ResponseEntity<Object>("Successfully removed author with id: " + authorId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
