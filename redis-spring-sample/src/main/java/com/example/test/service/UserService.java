/**
 * 
 */
package com.example.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import com.example.test.util.LogMethodTime;

/**
 * @author apinto
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@LogMethodTime
	public User saveUser(final User user) {
		return userRepository.saveUser(user);
	}
	
	@LogMethodTime
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	@LogMethodTime
	public User getUser(final String userId) {
		return userRepository.getUser(userId);
	}

}
