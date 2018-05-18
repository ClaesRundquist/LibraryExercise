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
	public Loan createLoan(LoanWrapper loanWrap) throws CreateLoanException {
		Optional<Book> book = bookRepository.findById(loanWrap.getBookId());
		if (!book.isPresent()) {

			throw new CreateLoanException("Book not found");
		}
		
		Optional<LibraryCard> libraryCard = libraryCardRepository.findById(loanWrap.getLibraryCardId());

		if (!libraryCard.isPresent()) {

			throw new CreateLoanException("Library card not found");
		} else if (libraryCard.get().isValid()) {
			Member member = memberRepository.getOne(libraryCard.get().getMember().getId());

			SimpleLoan simpleLoan = new SimpleLoan(book.get(), member);
			// Loan knows what data to add (date etc).
			Loan newLoan = new Loan(simpleLoan);
			loanRepository.save(newLoan);
			member.addLoan(newLoan);

			memberRepository.save(member);
			return newLoan;
		} else {
			throw new CreateLoanException("Invalid library card");
		}
	}

	@Override
	public List<Loan> getAll() {
		return loanRepository.findAll();
	}

	@Override
	public Optional<Loan> searchForLoanByBookId(Integer bookId) throws LoanNotFoundException {
		Optional<Book> book = bookRepository.findById(bookId);
		if (!book.isPresent()) {

			throw new LoanNotFoundException("Book not found");
		}
		Optional<Loan> res = loanRepository.findByBook(book.get());
		return res;
	}

	@Override
	public List<Loan> searchForLoansByMember(Integer memberId) {
		Optional<Member> member = memberRepository.findById(memberId);
		if (!member.isPresent()) {

//			throw new LoanNotFoundException("Member not found");
		}
		List<Loan> res = loanRepository.findByMember(member.get());
		return res;
	}

	@Override
	public List<Loan> searchForLoansByLibraryCard(Integer libraryCardId) throws LoanNotFoundException {

		Optional<LibraryCard> libraryCard = libraryCardRepository.findById(libraryCardId);
		if (!libraryCard.isPresent()) {

			throw new LoanNotFoundException("Library card not found");
		} else {

			if (libraryCard.get().isValid()) {

				List<Loan> loans = searchForLoansByMember(libraryCard.get().getMember().getId());
				return loans;
			} else {

				throw new LoanNotFoundException("Invalid library card");
			}
		}
	}

	@Override
	public List<Loan> searchForLoansByDueDate(LocalDate dueDate) {
		return null;
	}

	@Override
	public void returnBook(Integer bookId) throws LoanNotFoundException {
		Optional<Loan> loan=searchForLoanByBookId(bookId);
		if (loan.isPresent()) {
			// maybe mark overdue loans as returned here in future verions...
			loanRepository.deleteById(loan.get().getId());
		}
	}

}
