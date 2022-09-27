package com.productservicecatalog.productservicecatalog.exception;

import java.util.List;

public class ErrorMessage {

	private String message;
	private String code;

	public ErrorMessage(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public ErrorMessage(String message2, List<String> details) {
		
		}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
