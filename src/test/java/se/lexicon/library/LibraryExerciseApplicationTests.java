package se.lexicon.library;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import se.lexicon.library.domain.Member;
import se.lexicon.library.restcontrollers.SimpleMember;
import se.lexicon.library.services.members.MemberManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryExerciseApplicationTests {

	@Autowired
	private MemberManagementService memberService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreatingAMemberRecord() {
		SimpleMember newMember= new SimpleMember("Olle Karlsson", "Gubbegatan 11", "0123456789", "ollek@hotmail.com");
		Member createdMember=memberService.createMember(newMember);
		System.out.println(createdMember);
		assertEquals(true, createdMember.getName().equals("Olle Karlsson"));
	}
	
	
}
