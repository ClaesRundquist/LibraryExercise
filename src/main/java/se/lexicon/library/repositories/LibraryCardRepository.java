package se.lexicon.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.library.domain.LibraryCard;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {

}
