/**
 * 
 */
package com.microprofile.basic.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.LogManager;

import com.microprofile.basic.exception.BusinessException;
import com.microprofile.basic.exception.Logger;

/**
 * @author Davi Maçana
 *
 */
@Interceptor
@Logger
public class LoggerInterceptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object proccessMethod(InvocationContext context) throws Exception {

		org.apache.logging.log4j.Logger logger = LogManager.getLogger(context.getTarget().getClass());

		try {
			logger.debug("Called: " + context.getMethod());
			return context.proceed();
		} catch (Exception e) {
			treatException(e, context);
			throw e;

		}

	}

	private void treatException(Exception e, InvocationContext context) {

		org.apache.logging.log4j.Logger logger = LogManager.getLogger(context.getTarget().getClass());

		if (!(e instanceof BusinessException)) {
			logger.error(e);
		} else {
			logger.debug("Business Logic", e);
		}

	}
}
