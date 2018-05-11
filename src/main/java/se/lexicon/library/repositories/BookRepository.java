package se.lexicon.library.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.library.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
