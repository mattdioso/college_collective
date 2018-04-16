package cc.web;

import cc.model.Posts;
import cc.model.Threads;
import cc.model.School;

import cc.repository.TopicRepository;
import cc.repository.SchoolRepository;
import cc.repository.ThreadRepository;
import cc.repository.PostRepository;
import cc.repository.UserRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;


@Controller
public class CommentPageController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	TopicRepository topicRepository;

	@Autowired
	SchoolRepository schoolRepository;

	@Autowired
	ThreadRepository threadRepository; 

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/seattleu/{topic}", method=RequestMethod.GET)
	public String commentPage(Model model, @PathVariable("topic") String topic) {//, @PathVariable("id") String schoolID) {
		//School school = schoolRepository.findOne(schoolID);
		//model.addAttribute("selectedSchool", school);
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		//model.addAttribute("topics", topicRepository.findAllBySchoolID(school));
		model.addAttribute("threads", threadRepository.findAllByOrderByDateCreated());
		model.addAttribute("posts", postRepository.findAllByOrderByDateCreated());
		return topic;
	}
}