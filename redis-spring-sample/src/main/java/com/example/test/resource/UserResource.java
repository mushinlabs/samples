/**
 * 
 */
package com.example.test.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.test.model.User;
import com.example.test.service.UserService;

/**
 * @author apinto
 *
 */
@Controller
@Path(UserResource.PATH_USERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	
	public static final String PATH_USERS = "/users";
	
	@Autowired
	private UserService userService;
	
	@POST
	public User saveUser(final User user) {
		return userService.saveUser(user);
	}
	
	@GET
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/{userId}")
	public User getUser(@PathParam("userId") final String userId) {
		return userService.getUser(userId);
	}

}
