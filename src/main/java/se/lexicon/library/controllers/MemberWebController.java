package se.lexicon.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.lexicon.library.domain.Member;
import se.lexicon.library.restcontrollers.SimpleMember;
import se.lexicon.library.services.books.NotUniqueException;
import se.lexicon.library.services.members.MemberManagementService;

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

}
