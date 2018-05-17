package se.lexicon.library.services.loans;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.library.domain.Book;
import se.lexicon.library.domain.LibraryCard;
import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;
import se.lexicon.library.repositories.BookRepository;
import se.lexicon.library.repositories.LibraryCardRepository;
import se.lexicon.library.repositories.LoanRepository;
import se.lexicon.library.repositories.MemberRepository;
import se.lexicon.library.restcontrollers.SimpleLoan;

@Transactional
@Service
public class LoanManagementServiceImpl implements LoanManagementService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private LibraryCardRepository libraryCardRepository;

	@Override
	public Loan createLoan(LoanWrapper loanWrap) {
		Book book = bookRepository.findById(loanWrap.getBookId()).get();
		LibraryCard libraryCard = libraryCardRepository.findById(loanWrap.getLibraryCardId()).get();

		if (libraryCard.isValid()) {
System.out.println("Card valid");
			Member member = memberRepository.findById(libraryCard.getMember().getId()).get();

			SimpleLoan simpleLoan = new SimpleLoan(book, member);
			// Loan knows what data to add.
			Loan newLoan = new Loan(simpleLoan);

			member.addLoan(newLoan);

			memberRepository.save(member);

		} else {
			// throw LibraryCardPassedDueDateException;
		}
		return null;
	}

	@Override
	public List<Loan> getAll() {
		return loanRepository.findAll();
	}

	@Override
	public Loan searchForLoanById(String loanId) throws LoanNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> searchForLoansByMember(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> searchForLoansByLibraryCard(Integer libraryCardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> searchForLoansByDueDate(LocalDate dueDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLoan(String loanId) throws LoanNotFoundException {
		// TODO Auto-generated method stub

	}

}
