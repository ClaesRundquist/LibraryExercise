package se.lexicon.library.services.members;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;

import se.lexicon.library.domain.Member;
import se.lexicon.library.restcontrollers.SimpleMember;

public interface MemberManagementService {
	public Member createMember(SimpleMember newMember);

	public Optional<Member> searchForMemberById(Integer memberId);
	
	public Member addLibraryCard(AddLibraryCardWrapper setCardWrap) throws MemberNotFoundException;
	
	public Member searchForMemberByLibraryCard(Integer libraryCardId) throws MemberNotFoundException;

	public List<Member> searchForMembersByName(String name);
	public List<Member> getAll();

	public void updateMember(Member changedMember) throws MemberNotFoundException;

	public void deleteMember(Integer memberId) throws EmptyResultDataAccessException;
}
