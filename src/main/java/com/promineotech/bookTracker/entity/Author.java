package com.promineotech.bookTracker.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {

	private Long authorId;
	private String firstName;
	private String lastName;
	
	@JsonIgnore
	private Set<Book> books;
	
	@JsonIgnore
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(mappedBy = "author")
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
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
