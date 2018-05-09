package se.lexicon.library.restcontrollers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.ContactInfo;
import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;
import se.lexicon.library.services.members.MemberManagementService;

@RestController
@RequestMapping("/member")
public class MemberRestController {
		
		@Autowired
		MemberManagementService memberService;
		
		@PostMapping("/create/{name}/{phone}")
		public  ResponseEntity<Boolean> create(@PathVariable("name") String name, @PathVariable("phone") String phone) {
			
			Member newMember;
			List<Loan> loans = new ArrayList<Loan>();
			loans.add(new Loan());
			newMember=new Member(LocalDate.now(), new ContactInfo(name, phone), null, loans);
//			newMember=new Member(LocalDate.now(), null, loans);
						memberService.createMember(newMember);
	//		return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);

			return ResponseEntity.ok(true);

}
		
/*		@RequestMapping("/all")
		public List<Member> getAll() {
			return memberService.getList();
		}
*/
}
