package com.promineotech.bookTracker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bookTracker.entity.Author;
import com.promineotech.bookTracker.repository.AuthorRepository;

@Service
public class AuthorService {

	private static final Logger logger = LogManager.getLogger(AuthorService.class);
	
	@Autowired
	private AuthorRepository repo;
	
	public Author getAuthorById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve Author.");
			throw e;
		}
	}
	
	public Iterable<Author> getAuthors() {
		return repo.findAll();
	}
	
	public Author addAuthor(Author author) {
		return repo.save(author);
	}
	
	public Author updateAuthor(Author author, Long id) throws Exception {
		try {
			Author oldAuthor = repo.findOne(id);
			oldAuthor.setFirstName(author.getFirstName());
			oldAuthor.setLastName(author.getLastName());
			oldAuthor.setBooks(author.getBooks());
			return repo.save(oldAuthor);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update author.");
			throw new Exception("Unable to update author.");
		}
	}
	
	public void removeAuthor(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete author.");
			throw new Exception("Unable to remove author.");
		}
	}
}
