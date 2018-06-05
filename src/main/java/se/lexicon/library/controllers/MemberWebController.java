package se.lexicon.library.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.lexicon.library.domain.Member;
import se.lexicon.library.restcontrollers.MemberDTO;
import se.lexicon.library.restcontrollers.SimpleMember;
import se.lexicon.library.services.books.NotUniqueException;
import se.lexicon.library.services.members.MemberManagementService;
import se.lexicon.library.services.members.MemberNotFoundException;

	@Controller
	@RequestMapping("/member")
	public class MemberWebController {

		@Autowired
		MemberManagementService memberService;
		
		@GetMapping("/createForm")
		public String getCreateForm(Model m) {
			SimpleMember simpleMember = new SimpleMember();
			m.addAttribute("simpleMember", simpleMember);
			return "memberCreate";
		}

		@PostMapping("/createForm")
		public String fillCreateForm(SimpleMember simpleMember, Model m) throws NotUniqueException {

			Member res = memberService.createMember(simpleMember);
			m.addAttribute("simpleMember", new SimpleMember());
			m.addAttribute("res", res);
			
			return "memberCreate";
		}

		@GetMapping("/searchForm")
		public String getSearchForm(Model m) {
			Member member = new Member();
			m.addAttribute("member", member);
			return "memberSearch";
		}

		
		@GetMapping("/findToUpdate/{id}")
		public String getUpdateForm(@PathVariable("id") Integer id, Model m) throws MemberNotFoundException {
			Optional<Member> member=memberService.searchForMemberById(id);
			if (!member.isPresent()) {
				// concurrent deletes may cause this to happen, even though id is generated from database.
				throw new MemberNotFoundException("Member not found, deleted by another user?");
			}
			MemberDTO memberDTO=new MemberDTO(member.get());
			m.addAttribute("memberDTO", memberDTO);
			return "memberUpdate";
		}

		@PatchMapping("/updateForm")
		public String fillUpdateForm(MemberDTO memberDTO, Model m) throws MemberNotFoundException {

			Member res = memberService.updateMember(memberDTO);
			MemberDTO memberDTORes=new MemberDTO(res);
			m.addAttribute("memberDTO", memberDTORes);
			return "memberUpdate";
		}


}
