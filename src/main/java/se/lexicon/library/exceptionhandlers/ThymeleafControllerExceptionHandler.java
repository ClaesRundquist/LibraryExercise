package se.lexicon.library.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import se.lexicon.library.controllers.NotUniqueException;

	@ControllerAdvice(basePackages = { "se.lexicon.library.controllers" })
	public class ThymeleafControllerExceptionHandler {

		@ExceptionHandler({ NotUniqueException.class })
		public ResponseEntity<String> handleNotUniqueException(Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
