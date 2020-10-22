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
import com.microprofile.basic.exception.BusinessException;
import com.microprofile.basic.exception.Logger;

/**
 * @author Davi Maçana
 *
 */
@Logger
@Provider
public class BusinessExceptionsMapper implements ExceptionMapper<BusinessException> {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BusinessExceptionsMapper.class);

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response toResponse(BusinessException ex) {
		String randomError = String.valueOf(new Random().nextInt());
		logger.warn("Random: " + randomError, ex);
		ErrorResponseDTO response = new ErrorResponseDTO(LocalDateTime.now(), ex.getMessage(),
				Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.name(), randomError);
		return Response.ok().entity(response).build();
	}

}
