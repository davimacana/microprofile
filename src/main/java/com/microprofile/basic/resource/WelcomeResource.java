/**
 * 
 */
package com.microprofile.basic.resource;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.microprofile.basic.utils.Config;

/**
 * @author Davi Maçana
 *
 */
@Path("/welcome")
public class WelcomeResource {

	@Inject
	private Config config;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response message() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("message", config.WELCOME);

		return Response.status(Response.Status.OK).entity(map).build();

	}

	@GET
	@Path("/external")
	@Produces(MediaType.APPLICATION_JSON)
	public Response messageExternalFile() {

		Map<String, String> map = new HashMap<String, String>();
		map.put("message", config.WELCOME_EXTERNAL_FILE);

		return Response.status(Response.Status.OK).entity(map).build();

	}
}
