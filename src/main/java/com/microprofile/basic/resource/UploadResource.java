/**
 * 
 */
package com.microprofile.basic.resource;

import java.io.File;
import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.microprofile.basic.utils.FileDao;

/**
 * @author Davi Maçana
 *
 */
@Path("/upload")
public class UploadResource {

	@Inject
	private FileDao fileDao;

	@POST
	public Response upload(File file) {
		if (fileDao.save(file)) {
			return Response.created(URI.create("/download?fileName=" + file.getName())).build();
		}
		return Response.serverError().build();
	}
}
