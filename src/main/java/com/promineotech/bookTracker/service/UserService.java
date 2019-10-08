package com.promineotech.bookTracker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.bookTracker.entity.User;
import com.promineotech.bookTracker.repository.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public User login(User user) throws Exception {
		User foundUser = repo.findByUsername(user.getUsername());
		if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		} else {
			throw new Exception("Invalid username or password.");
		}
	}
	
	public User getUserById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve user: " + id, e);
			throw e;
		}
	}
	
	public Iterable<User> getUsers() {
		return repo.findAll();
	}

	public User updateProfilePicture(Long userId, String url) throws Exception {
		User user = repo.findOne(userId);
		if (user == null) {
			throw new Exception("User does not exist.");
		}
		user.setProfilePictureUrl(url);
		return repo.save(user);
	}
}
