package se.lexicon.library.services.members;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;
import se.lexicon.library.restcontrollers.SimpleMember;

public interface MemberManagementService {
	public Member createMember(SimpleMember newMember);
	// TODO return Loan to make receipt printout possible.
	public void createLoan(LoanWrapper loanWrap);

	public Optional<Member> searchForMemberById(Integer memberId);

	public Member searchForMemberByLibraryCard(Integer libraryCardId) throws MemberNotFoundException;

	public List<Member> searchForMembersByName(String name);
	public List<Member> getAll();

	public void updateMember(Member changedMember) throws MemberNotFoundException;

	public void deleteMember(Member member) throws EmptyResultDataAccessException;

	public void deleteMember(Integer memberId) throws EmptyResultDataAccessException;
}
