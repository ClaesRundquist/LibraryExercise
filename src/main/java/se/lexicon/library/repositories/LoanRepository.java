package se.lexicon.library.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.library.domain.Book;
import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
		public Optional<Loan> findByBook(Book book);
		public List<Loan> findByMember(Member member);
}
