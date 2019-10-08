package com.promineotech.bookTracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.bookTracker.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}
