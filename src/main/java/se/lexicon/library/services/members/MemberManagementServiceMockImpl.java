package se.lexicon.library.services.members;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public Member createMember(Member member) {
		// Library card assignment (Id generation) is mock implementation. Id will be
		// read from printing on physical card, not generated here.
			memberRepository.save(member);
			member.setLibraryCard(new LibraryCard(member.getId() + 1000_000));
		return (member);
	}

	@Override
	public Optional<Member> searchForMemberById(Integer memberId) throws MemberNotFoundException {
		return memberRepository.findById(memberId);
	}

	@Override
	public List<Member> searchForMembersByName(String name) {
		return memberRepository.findByName(name);
	}

	@Override
	public Member searchForMemberByLibraryCard(Integer libraryCardId) throws MemberNotFoundException {
		// TODO Auto-generated method stub
//		memberRepository.
		return null;
	}

	@Override
	public List<Member> getAll() {
		return memberRepository.findAll();
	}
	

	@Override
	public void updateMember(Member changedMember) throws MemberNotFoundException {
		memberRepository.save(changedMember);
	}

	@Override
	public void deleteMember(Member member) throws EmptyResultDataAccessException {
		memberRepository.delete(member);
	}

	@Override
	public void deleteMember(Integer memberId) throws EmptyResultDataAccessException {
		memberRepository.deleteById(memberId);
	}
}
