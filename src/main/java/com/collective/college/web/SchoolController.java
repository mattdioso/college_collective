package com.collective.college.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;

import cc.repository.SchoolRepository;

import cc.model.School;

@Controller
public class SchoolController {	

	@Autowired
	private SchoolRepository schoolRepository;

	@RequestMapping(value = "/school/{id}", method = RequestMethod.GET)
	public String changeSchools(Model model, @PathVariable("id") String id) {
		School school = schoolRepository.findOne(id);
		model.addAttribute("selectedSchool", school);
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		return "school";
	}

}