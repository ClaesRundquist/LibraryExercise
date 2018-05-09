package se.lexicon.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.library.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
