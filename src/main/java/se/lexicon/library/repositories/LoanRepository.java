package se.lexicon.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import se.lexicon.library.domain.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
