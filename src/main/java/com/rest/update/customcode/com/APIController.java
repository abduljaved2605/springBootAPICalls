package com.rest.update.customcode.com;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	static Validation validation;

	// Load the class GetPostApiRequest
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
			com.rest.update.customcode.com.TagMultithread.class);
	
	TagMultithread tagMultithread = context.getBean(TagMultithread.class);
	
	

	@GetMapping("/post")
	public ResponseEntity<ErrorMessage> queryTagParam(@RequestParam String tag, @RequestParam String sortBy,
			@RequestParam String direction) throws UnsupportedOperationException, IOException, InterruptedException, ExecutionException {

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

		String response = tagMultithread.tagMultithread(tag, sortBy, direction);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
	}

	
}
