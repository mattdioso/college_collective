package cc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/seattleu", method = RequestMethod.GET)
	public String changeSchools() {
		return "seattleu";
	}

	@RequestMapping(value = "/schoolcomments", method = RequestMethod.GET)
	public String goToComments() {
		return "schoolcomments";
	}

	@RequestMapping(value="/schoolcomments?slide={slideID}", method=RequestMethod.GET)
	public String goToSpecificComments(@PathVariable(value="slideID") String slideID) {
		return "schoolcomments?slide=" + slideID;
	}
}
