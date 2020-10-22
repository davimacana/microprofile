/**
 * 
 */
package com.microprofile.basic.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Davi Maçana
 *
 */
public class ErrorResponseDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	private Integer code;
	private String status;
	private String error;
	private String codeErrorRandom;

	public ErrorResponseDTO() {
		super();
	}

	public ErrorResponseDTO(LocalDateTime now, String message, int value, String name, String codeErrorRandom) {
		super();
		this.timestamp = now;
		this.error = message;
		this.code = value;
		this.status = name;
		this.codeErrorRandom = codeErrorRandom;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Integer getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getCodeErrorRandom() {
		return codeErrorRandom;
	}
}
