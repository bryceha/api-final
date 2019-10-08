package com.promineotech.bookTracker.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.promineotech.bookTracker.util.BookRating;

@Entity
public class Book {

	private Long bookId;
	private String title;
	private String genre = "Thriller";
	private Long publishYear;
	private String readDate;
	
	@Enumerated(EnumType.STRING)
	private BookRating rating = BookRating.GD;
	
	private Author author;

	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Long publishYear) {
		this.publishYear = publishYear;
	}

	public String getReadDate() {
		return readDate;
	}

	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}

	public BookRating getRating() {
		return rating;
	}

	public void setRating(BookRating rating) {
		this.rating = rating;
	}

	@ManyToOne
	@JoinColumn(name = "authorId")
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
 