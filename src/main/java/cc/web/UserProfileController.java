package cc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

import cc.model.User;
import cc.repository.UserRepository;

@Controller
public class UserProfileController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/profile/{username}", method=RequestMethod.GET)
	public String showUserInfo(@PathVariable("username") String username, Model model) {
		model.addAttribute("user", userRepository.findByUserName(username));
		return "profile";
	}
}
