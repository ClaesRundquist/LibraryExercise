package se.lexicon.library.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import se.lexicon.library.services.books.BookNotFoundException;
import se.lexicon.library.services.loans.CreateLoanException;
import se.lexicon.library.services.loans.InvalidLibraryCardException;
import se.lexicon.library.services.loans.LoanNotFoundException;
import se.lexicon.library.services.members.MemberNotFoundException;

@ControllerAdvice(basePackages = { "se.lexicon.library.restcontrollers" })
public class RestControllerExceptionHandler {

	@ExceptionHandler({ InvalidLibraryCardException.class })
	public ResponseEntity<String> handleCreateException(Exception e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler({ MemberNotFoundException.class, LoanNotFoundException.class, BookNotFoundException.class,
			CreateLoanException.class })
	public ResponseEntity<String> handleException(Exception e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}