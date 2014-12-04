/**
 * 
 */
package com.example.test.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author apinto
 *
 */
@Path("/")
public class PingResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "pong";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{message}")
	public String ping(@PathParam("message") final String message) {
		return message;
	}
	
}
