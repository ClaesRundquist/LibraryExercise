package se.lexicon.library.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.library.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findByIsbn(String isbn);
	public List<Book> findByTitle(String title);
	
}
