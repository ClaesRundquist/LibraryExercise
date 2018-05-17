package se.lexicon.library.services.loans;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
import se.lexicon.library.services.members.MemberNotFoundException;

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
	public Loan createLoan(LoanWrapper loanWrap) throws LibraryCardNotFoundException {
		Book book = bookRepository.findById(loanWrap.getBookId()).get();
		Optional<LibraryCard> libraryCard = libraryCardRepository.findById(loanWrap.getLibraryCardId());
		if (!libraryCard.isPresent()) {

			throw new LibraryCardNotFoundException("Library card not found");
		} else if (libraryCard.get().isValid()) {
			Member member = memberRepository.getOne(libraryCard.get().getMember().getId());

			SimpleLoan simpleLoan = new SimpleLoan(book, member);
			// Loan knows what data to add (date etc).
			Loan newLoan = new Loan(simpleLoan);
			loanRepository.save(newLoan);
			member.addLoan(newLoan);

			memberRepository.save(member);
			return newLoan;
		} else {
			throw new LibraryCardNotFoundException("Invalid library card");
		}
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
