package se.lexicon.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeWebController {

	@GetMapping("/home")
	public String getIndexPage(Model m) {
		return "home";
	}
	
	@GetMapping("/")
	public String getRootPage(Model m) {
		return "redirect:/home";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
/*	
	@GetMapping("/login")
	public String getLoginPage(Model m) {
		return "login";
	}

	@PostMapping("/login")
	public String postLoginPage(Model m) {
		return "home";
	}
*/
	
	@PostMapping("/logout")
	public String postLogout(Model m) {
		return "home";
	}

	
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "redirect:/home";
	}
	
	
}

