package se.lexicon.library.services.members;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.library.domain.LibraryCard;
import se.lexicon.library.domain.Member;
import se.lexicon.library.repositories.LibraryCardRepository;
import se.lexicon.library.repositories.MemberRepository;
import se.lexicon.library.restcontrollers.SimpleMember;

@Transactional
@Service
public class MemberManagementServiceMockImpl implements MemberManagementService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private LibraryCardRepository libraryCardRepository;

	public MemberManagementServiceMockImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Member createMember(SimpleMember simpleMember) {
		Member newMember = new Member(simpleMember);
		// persist member
		Member member=memberRepository.save(newMember);

		// Library card assignment (Id generation) is mock implementation. Id will be
		// read from printing on physical card, not generated here.
//		LibraryCard libraryCard = libraryCardRepository.save(new LibraryCard(newMember.getId() + 1000_000, newMember));
	
//		member.setLibraryCard(libraryCard);
		
//		member=memberRepository.save(member);
		return (member);
	}

	@Override
	public Member addLibraryCard(AddLibraryCardWrapper setCardWrap) throws MemberNotFoundException {
		Member member = memberRepository.getOne(setCardWrap.getMemberId());
		LibraryCard libraryCard = libraryCardRepository.save(new LibraryCard(setCardWrap.getLibraryCardId(), member));
		member.setLibraryCard(libraryCard);
		Member res=memberRepository.save(member);
		
		return res;
	}
	

	@Override
	public Optional<Member> searchForMemberById(Integer memberId) {
		Optional<Member> res = memberRepository.findById(memberId);
		return res;
	}

	@Override
	public List<Member> searchForMembersByName(String name) {
		return memberRepository.findByName(name);
	}

	@Override
	public Member searchForMemberByLibraryCard(Integer libraryCardId) throws MemberNotFoundException {

		Optional<LibraryCard> libraryCard = libraryCardRepository.findById(libraryCardId);
		if (!libraryCard.isPresent()) {

			throw new MemberNotFoundException("Library card not found");
		} else {

			if (libraryCard.get().isValid()) {

				Member member = memberRepository.findById(libraryCard.get().getMember().getId()).get();
				return member;
			} else {

				throw new MemberNotFoundException("Invalid library card");
			}
		}
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
	public void deleteMember(Integer memberId) throws EmptyResultDataAccessException {
		memberRepository.deleteById(memberId);
	}
}
