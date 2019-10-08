package com.promineotech.bookTracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bookTracker.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
