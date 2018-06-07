package se.lexicon.library.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import se.lexicon.library.services.books.NotUniqueException;
import se.lexicon.library.services.loans.LoanNotFoundException;

	@ControllerAdvice(basePackages = { "se.lexicon.library.controllers" })
	public class ThymeleafControllerExceptionHandler {

		@ExceptionHandler({ NotUniqueException.class })
		public ResponseEntity<String> handleNotUniqueException(Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		
		
	}
