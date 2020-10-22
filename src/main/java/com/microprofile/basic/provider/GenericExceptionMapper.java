/**
 * 
 */
package com.microprofile.basic.provider;

import java.time.LocalDateTime;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;

import com.microprofile.basic.dto.ErrorResponseDTO;
import com.microprofile.basic.exception.Logger;

/**
 * @author Davi Maçana
 *
 */
@Logger
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(GenericExceptionMapper.class);

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response toResponse(Exception ex) {
		String randomError = String.valueOf(new Random().nextInt());
		logger.error("Random: " + randomError, ex);
		ErrorResponseDTO response = new ErrorResponseDTO(LocalDateTime.now(), ex.getMessage(),
				Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.name(), randomError);
		return Response.ok().entity(response).build();
	}

}
