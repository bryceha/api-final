package com.promineotech.bookTracker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bookTracker.entity.Author;
import com.promineotech.bookTracker.entity.Book;
import com.promineotech.bookTracker.repository.AuthorRepository;
import com.promineotech.bookTracker.repository.BookRepository;

@Service
public class BookService {
	
	private static final Logger logger = LogManager.getLogger(BookService.class);

	@Autowired
	private BookRepository repo;
	
	public Iterable<Book> getBooks() {
		return repo.findAll();
	}
	
	public Book getBookById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve book.");
			throw e;
		}
	}
	
	@Autowired
	private AuthorRepository authorRepo;
	
	public Book addBook(Book book, Long userId) throws Exception {
		Author author = authorRepo.findOne(userId);
		if (author == null) {
			logger.error("Exception occured while trying to add book.");
			throw new Exception("Author does not exist in database.");
		}
		book.setAuthor(author);
		return repo.save(book);
	}
	
	public Book updateBook(Book book, Long id) throws Exception {
		try {
			Book oldBook = repo.findOne(id);
			oldBook.setAuthor(book.getAuthor());
			oldBook.setGenre(book.getGenre());
			oldBook.setPublishYear(book.getPublishYear());
			oldBook.setRating(book.getRating());
			oldBook.setReadDate(book.getReadDate());
			oldBook.setTitle(book.getTitle());
			return repo.save(oldBook);
		} catch (Exception e) {
			logger.error("Exception occured while trying to update book.");
			throw new Exception("Unable to update book.");
		}
	}
	
	public void removeBook(Long id) throws Exception {
		try {
		repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete book: " + id, e);
			throw new Exception("Unable to remove book.");
		}
	}
}
