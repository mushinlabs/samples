/**
 * 
 */
package com.example.test.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.test.model.User;

/**
 * @author apinto
 *
 */
@Repository
public class UserRepository {
	
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	
	private static String generateUniqueId(final String seedString) {
		String seed = seedString + System.currentTimeMillis();
		return DigestUtils.sha256Hex(seed);
	}
	
	public User saveUser(final User user) {
		String userId = generateUniqueId(user.getUsername());
		user.setId(userId);
		redisTemplate.opsForHash().put("user", userId, user);
		return user;
	}
	
	public List<User> getAllUsers() {
		Collection<Object> allUserObjects = redisTemplate.opsForHash().entries("user").values();
		List<User> users = new ArrayList<User>();
		for(Object userObject : allUserObjects) {
			users.add((User) userObject);
		}
		return users;
	}
	
	public User getUser(final String userId) {
		return (User) redisTemplate.opsForHash().get("user", userId);
	}

}
