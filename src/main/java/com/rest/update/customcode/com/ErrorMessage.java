package com.rest.update.customcode.com;

import org.springframework.stereotype.Controller;

@Controller
public class ErrorMessage {
	
	String error;
	String ResponseStatusCode;
	
public ErrorMessage() {
	// TODO Auto-generated constructor stub
}	
	public ErrorMessage(String errorMessage, String errorCode) {
		this.error = errorMessage;
		this.ResponseStatusCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getResponseStatusCode() {
		return ResponseStatusCode;
	}

	public void setResponseStatusCode(String responseStatusCode) {
		ResponseStatusCode = responseStatusCode;
	}

		

}
