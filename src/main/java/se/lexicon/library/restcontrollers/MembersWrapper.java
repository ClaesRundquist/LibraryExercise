package se.lexicon.library.restcontrollers;

import java.util.List;

import se.lexicon.library.domain.Member;

public class MembersWrapper {
	List<Member> members;

	
	public MembersWrapper() {
		super();
	}


	public MembersWrapper(List<Member> members) {
		super();
		this.members = members;
	}


	public List<Member> getMembers() {
		return members;
	}


	public void setMembers(List<Member> members) {
		this.members = members;
	}


	@Override
	public String toString() {
		return "MembersWrapper [members=" + members + "]";
	}
	
}
