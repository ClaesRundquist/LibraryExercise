package se.lexicon.library.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.library.domain.Member;
import se.lexicon.library.services.members.AddLibraryCardWrapper;
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

	@PatchMapping("/update")
	public ResponseEntity<Member> update(@RequestBody MemberDTO updatedMemberDTO) throws MemberNotFoundException {

		return ResponseEntity.ok(memberService.updateMember(updatedMemberDTO));

	}
	
	
	@PatchMapping("/addlibrarycard")
	public ResponseEntity<?> addLibraryCard(@RequestBody AddLibraryCardWrapper addCardWrap)
			throws MemberNotFoundException {

		Member res;
		res = memberService.addLibraryCard(addCardWrap);
		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbyname/{name}")
	public ResponseEntity<MembersWrapper> findByName(@PathVariable("name") String name) {

		MembersWrapper res;
		res = new MembersWrapper(memberService.searchForMembersByName(name));
		return ResponseEntity.ok(res);

	}

	@GetMapping("/findbyid/{memberId}")
	public ResponseEntity<Optional<Member>> findById(@PathVariable("memberId") Integer memberId) {

/*		Optional<Member> res;
		res = memberService.searchForMemberById(memberId);
		if (res.isPresent()) {
			return ResponseEntity.ok(res);
		} else {
			return new ResponseEntity<Optional<Member>>(HttpStatus.NOT_FOUND);
		}
*/
		return ResponseEntity.ok(memberService.searchForMemberById(memberId));
	}

	@GetMapping("/findbycardid/{libraryCardId}")
	public ResponseEntity<Member> findByLibraryCardId(@PathVariable("libraryCardId") Integer libraryCardId)
			throws MemberNotFoundException {

		Member res;
		res = memberService.searchForMemberByLibraryCard(libraryCardId);
		return ResponseEntity.ok(res);

	}

	@GetMapping("/all")
	public ResponseEntity<MembersWrapper> getAll() {

		MembersWrapper res;
		res = new MembersWrapper(memberService.getAll());
		return ResponseEntity.ok(res);

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
