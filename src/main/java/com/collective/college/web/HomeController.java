package com.collective.college.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import cc.repository.SchoolRepository;

import org.springframework.ui.Model;

@Controller
public class HomeController {

	@Autowired
	SchoolRepository schoolRepository;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	
}
