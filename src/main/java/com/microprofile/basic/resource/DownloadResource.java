/**
 * 
 */
package com.microprofile.basic.resource;

import java.io.File;
import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.microprofile.basic.exception.Logger;
import com.microprofile.basic.utils.FileDao;

/**
 * @author Davi Maçana
 *
 */
@Path("/download")
@Logger
public class DownloadResource {

	@Inject
	private FileDao fileDao;

	@GET
	public Response download(@QueryParam("fileName") String fileName) {

		File file = fileDao.find(fileName);

		if (Objects.isNull(file)) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok(file).header("Content-Disposition", "attachment; filename=\"" + fileName + "\"").build();
	}

}
