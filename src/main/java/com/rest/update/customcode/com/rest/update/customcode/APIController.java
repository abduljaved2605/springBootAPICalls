package com.rest.update.customcode.com.rest.update.customcode;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.read.write.api.GetPostApiRequest;

@RestController
public class APIController {

	static Validation validation;

	// Load the class GetPostApiRequest
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
			com.read.write.api.GetPostApiRequest.class);
	GetPostApiRequest getPostApiRequest = context.getBean(GetPostApiRequest.class);

	@GetMapping("/post")
	public ResponseEntity<ErrorMessage> queryTagParam(@RequestParam String tag, @RequestParam String sortBy,
			@RequestParam String direction) throws UnsupportedOperationException, IOException {

		// Checcks for tag parameter
		if (!Validation.validateTagParameter(tag)) {
			return new ResponseEntity<>(new ErrorMessage("Tag parameter is required", "400"), HttpStatus.NOT_FOUND);
		}

		// Checks for tag parameter
		if (!Validation.validateSortBy(sortBy)) {
			return new ResponseEntity<>(new ErrorMessage("Sort by value should be id,reads,likes,popularity", "400"),
					HttpStatus.NOT_FOUND);
		}

		// Checks for direction parameter
		if (!Validation.validateDirection(sortBy)) {
			return new ResponseEntity<>(new ErrorMessage("Directions by value should be asc or desc", "400"),
					HttpStatus.NOT_FOUND);
		}

		String response = getPostApiRequest.getAPIResponseforQueryParams(tag, sortBy, direction);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
	}

	
}
