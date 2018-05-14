package se.lexicon.library.restcontrollers;

import java.util.List;

import se.lexicon.library.domain.Member;

public class MemberCollection {
	List<Member> members;

	
	public MemberCollection() {
		super();
	}


	public MemberCollection(List<Member> members) {
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
		return "Members [members=" + members + "]";
	}
	
}
