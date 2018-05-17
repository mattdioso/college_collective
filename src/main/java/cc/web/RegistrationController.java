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

import cc.service.UserService;
import cc.service.FileSystemStorageService;

import cc.web.util.GenericResponse;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import cc.model.User;
import cc.web.vo.UserVO;
import cc.web.vo.ChangePasswordVO;

import cc.repository.SchoolRepository;

import javax.validation.Valid;


@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private FileSystemStorageService filesystem;

	@RequestMapping(value="/registernewuser", method=RequestMethod.GET)
	public String showRegistrationForm(final Model model) {
		final UserVO userVo = new UserVO();
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		model.addAttribute("user", userVo);
		return "registernewuser";
	}

	@RequestMapping(value="/registration/register", method=RequestMethod.GET)
	public String registrationForm(final Model model) {
		final UserVO userVo = new UserVO();
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		model.addAttribute("user", userVo);
		return "registration";
	}

	@RequestMapping(value="/registration/change_password", method=RequestMethod.GET)
	public String changePasswordForm(final Model model) {
		final ChangePasswordVO changePassword = new ChangePasswordVO();
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		model.addAttribute("changePassword", changePassword);
		return "changepassword";
	}

	@RequestMapping(value="/registration/register", method=RequestMethod.POST)
	public String registerUserAccount(@ModelAttribute("user") @Valid UserVO userVo, @RequestParam("file") MultipartFile file, HttpServletRequest request, Errors errors) {

		final User registered = userService.registerNewUserAccount(userVo);
		//filesystem.store(file);
		return "redirect:/";
	}

	@RequestMapping(value="/registration/change_password", method=RequestMethod.POST)
	public String changePassword(@ModelAttribute("changePassword") @Valid ChangePasswordVO changepasswordVo) {
		userService.changeUserPassword(changepasswordVo);
		return "redirect:/";
	}
}