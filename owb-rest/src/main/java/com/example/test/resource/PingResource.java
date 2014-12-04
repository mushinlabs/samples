/**
 * 
 */
package com.example.test.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.test.service.PingService;

/**
 * @author apinto
 *
 */
@Path("/ping")
public class PingResource {
	
	@Inject
	private PingService pingService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "pong";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{message}")
	public String ping(@PathParam("message") final String message) {
		return pingService.ping(message);
	}
	
}
