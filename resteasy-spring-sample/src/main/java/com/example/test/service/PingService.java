/**
 * 
 */
package com.example.test.service;

import org.springframework.stereotype.Service;




/**
 * @author apinto
 *
 */
@Service
public class PingService {

	public String ping(final String message) {
		return "Ping message received: "+message;
	}
	
}
