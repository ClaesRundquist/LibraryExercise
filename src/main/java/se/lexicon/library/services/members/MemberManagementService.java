package se.lexicon.library.services.members;

import java.util.List;

import se.lexicon.library.domain.Member;

public interface MemberManagementService {
	public void createMember(Member newMember);

	public Member searchForMemberById(String memberId) throws MemberNotFoundException;

	public Member searchForMemberByLibraryCard(String libraryCardId) throws MemberNotFoundException;

	public List<Member> searchForMembersByName(String name);

	public void updateMember(Member changedMember) throws MemberNotFoundException;

	public void deleteMember(Member member) throws MemberNotFoundException;

}
