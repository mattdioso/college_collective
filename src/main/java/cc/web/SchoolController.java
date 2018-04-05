package cc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

@Controller
public class SchoolController {	
	@RequestMapping(value = "/seattleu", method = RequestMethod.GET)
	public String changeSchools() {
		return "seattleu";
	}

	@RequestMapping(value = "/schoolcomments", method = RequestMethod.GET)
	public String goToComments() {
		return "schoolcomments";
	}

	@RequestMapping(value = "/schoolfinancial", method=RequestMethod.GET)
	public String financialInformation() {
		return "schoolfinancial";
	}

	@RequestMapping(value = "/schoolnightlife", method = RequestMethod.GET)
	public String nightlife() {
		return "schoolnightlife";
	}

	@RequestMapping(value = "/schoolcampus", method = RequestMethod.GET)
	public String campus() {
		return "schoolcampus";
	}

	@RequestMapping(value = "/schoolprofessors", method = RequestMethod.GET)
	public String professors() {
		return "schoolprofessors";
	}

	@RequestMapping(value = "/schooltrends", method = RequestMethod.GET)
	public String trends() {
		return "schooltrends";
	}

	@RequestMapping(value = "/schoolsocial", method = RequestMethod.GET)
	public String social() {
		return "schoolsocial";
	}

	@RequestMapping(value = "/schooltransit", method = RequestMethod.GET)
	public String transit() {
		return "schooltansit";
	}
}