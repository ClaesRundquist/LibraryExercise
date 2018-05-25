package se.lexicon.library.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import se.lexicon.library.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findByIsbn(String isbn);
	public List<Book> findByTitle(String title);
	public List<Book> findByAuthor(String author);
	
	@Query("select b from Book b where b.isbn = ?1 and b.location = ?2 and b.loanPeriod = ?3")
	Optional<Book> findByISBNLocationLoanPeriod(String isbn, String location, Long loanPeriod);

}
