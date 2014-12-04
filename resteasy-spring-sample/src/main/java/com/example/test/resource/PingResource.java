/**
 * 
 */
package com.example.test.resource;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.test.service.PingService;

/**
 * @author apinto
 *
 */
@Controller
@Path(PingResource.PATH_PING)
public class PingResource {
	
	public static final String PATH_PING = "/ping";
	
	@Autowired
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
	
	@GET
	@Path("/async/{message}")
	@Produces(MediaType.TEXT_PLAIN)
	public void asyncPing(@PathParam("message") final String message, @Suspended final AsyncResponse asyncResponse) {
		asyncResponse.setTimeout(3, TimeUnit.SECONDS);
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				asyncResponse.resume(Response.ok(pingService.ping(message)).type(MediaType.TEXT_PLAIN).build());
			}
		});
	}
	
}
