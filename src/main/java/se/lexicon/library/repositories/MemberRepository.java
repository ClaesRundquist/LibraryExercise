package se.lexicon.library.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.library.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	public List<Member> findByName(String name);
	
	
}
