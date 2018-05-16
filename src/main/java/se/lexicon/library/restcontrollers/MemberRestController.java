package se.lexicon.library.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.LibraryCard;
import se.lexicon.library.domain.Loan;
import se.lexicon.library.domain.Member;
import se.lexicon.library.services.members.MemberManagementService;
import se.lexicon.library.services.members.MemberNotFoundException;

@RestController
@RequestMapping("/member")
public class MemberRestController {

	@Autowired
	MemberManagementService memberService;

	@PostMapping("/create")
	public ResponseEntity<Member> create(@RequestBody SimpleMember simpleMember) {

		return ResponseEntity.ok(memberService.createMember(simpleMember));

	}

	@PostMapping("/createloan")
	public ResponseEntity<Loan> createLoan(@RequestBody SimpleLoan simpleLoan) {

		return ResponseEntity.ok(memberService.createLoan(simpleLoan));

	}

	
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<MemberCollection> findByName(@PathVariable("name") String name) {

		MemberCollection res;
		res = new MemberCollection(memberService.searchForMembersByName(name));

		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbyid/{memberId}")
	public ResponseEntity<Optional<Member>> findById(@PathVariable("memberId") String memberId) {

		Optional<Member> res;
		try {
			res = memberService.searchForMemberById(Integer.valueOf(memberId));
		} catch (MemberNotFoundException e) {
			return new ResponseEntity<Optional<Member>>(HttpStatus.BAD_REQUEST);
		}

		if (res.isPresent() == true) {
			return ResponseEntity.ok(res);

		} else {
			return new ResponseEntity<Optional<Member>>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/all")
	public ResponseEntity<MemberCollection> getAll() {
		MemberCollection res;
		res=new MemberCollection(memberService.getAll());

		return ResponseEntity.ok(res);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestBody Member member) {
		try {
			memberService.deleteMember(member);
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(true);		
	}
	
	
	
	@DeleteMapping("/delete/{memberId}")
	public ResponseEntity<Boolean> delete(@PathVariable("memberId") Integer memberId) {
		try {
			memberService.deleteMember(memberId);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(true);		
	}

}
