package se.lexicon.library.services.members;

import java.util.List;

import se.lexicon.library.domain.ContactInfo;
import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;
import se.lexicon.library.repositories.MemberRepository;

public class MemberManagementServiceMockImpl implements MemberManagementService {

	
	private MemberRepository memberRepository;
	
	public MemberManagementServiceMockImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createMember(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
	}

	@Override
	public void createLoan(Member member, Loan loan) {
		// TODO Auto-generated method stub

	}

	@Override
	public Member searchForMemberById(String memberId) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> searchForMembersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Member changedMember, ContactInfo changedContactInfo) throws MemberNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(Member member) throws MemberNotFoundException {
		// TODO Auto-generated method stub

	}

}
