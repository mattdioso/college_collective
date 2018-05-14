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

import cc.service.IUserService;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import cc.model.User;
import cc.web.vo.UserVO;

import javax.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value="/user/registration", method=RequestMethod.GET)
	public String showRegistrationForm(final Model model) {
		final UserVO userVo = new UserVO();
		model.addAttribute("user", userVo);
		return "registration";
	}

	@RequestMapping(value="/user/registration", method=RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserVO userVo, HttpServletRequest request, Errors errors) {

		final User registered = userService.registerNewUserAccount(userVo);

		if (registered == null) {
			return new ModelAndView("registration", "user", userVo);
		}

		return new ModelAndView("successRegister", "user", userVo);
	}
}