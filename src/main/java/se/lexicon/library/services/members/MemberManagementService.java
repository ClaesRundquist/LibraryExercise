package se.lexicon.library.services.members;

import java.util.List;


import se.lexicon.library.domain.ContactInfo;
import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;


public interface MemberManagementService {
	public void createMember(Member member);
	
	public void createLoan(Member member, Loan loan);
	
	public Member searchForMemberById(String memberId) throws MemberNotFoundException;

	public List<Member> searchForMembersByName (String name);
	
	public void updateMember(Member changedMember, ContactInfo changedContactInfo) throws MemberNotFoundException;
	
	public void deleteMember(Member member) throws MemberNotFoundException;
	
}
