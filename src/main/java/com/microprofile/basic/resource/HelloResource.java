package com.microprofile.basic.resource;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.microprofile.basic.exception.Logger;
import com.microprofile.basic.utils.Config;

/**
 *
 */
@Path("/hello")
@Singleton
@Logger
public class HelloResource {
	
	@Inject
	private Config config;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response message() throws Exception {

		if (true) 
			throw new Exception("Ocorreu um erro");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", config.WELCOME);

		return Response.status(Response.Status.OK).entity(map).build();

	}
}
