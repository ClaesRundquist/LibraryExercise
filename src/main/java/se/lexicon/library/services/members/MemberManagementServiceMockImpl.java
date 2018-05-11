package se.lexicon.library.services.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.library.domain.LibraryCard;
import se.lexicon.library.domain.Member;
import se.lexicon.library.repositories.MemberRepository;

@Transactional
@Service
public class MemberManagementServiceMockImpl implements MemberManagementService {

	@Autowired
	private MemberRepository memberRepository;

	public MemberManagementServiceMockImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createMember(Member member) {
		// TODO Auto-generated method stub
		// Library card assignment (Id generation) is mock implementation. Id will be read from printing on physical card, not generated here.
		member.setLibraryCard(new LibraryCard(member.getId()+1000_000));
		memberRepository.save(member);
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
	public void deleteMember(Member member) throws MemberNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public Member searchForMemberByLibraryCard(String libraryCardId) throws MemberNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Member changedMember) throws MemberNotFoundException {
		// TODO Auto-generated method stub

	}

}
