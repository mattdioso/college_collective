package cc.web;

import cc.model.Post;
import cc.model.Thread;
import cc.model.School;
import cc.model.Topic;
import cc.model.User;

import cc.repository.TopicRepository;
import cc.repository.SchoolRepository;
import cc.repository.ThreadRepository;
import cc.repository.PostRepository;
import cc.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import java.sql.Date;

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

	@RequestMapping(value = "school/{schoolID}/{topic}", method=RequestMethod.GET)
	public String commentPage(Model model, @PathVariable("topic") String topic, @PathVariable("schoolID") String schoolID) {
		School school = schoolRepository.findOne(schoolID);
		model.addAttribute("selectedSchool", school);
		model.addAttribute("schools", schoolRepository.findAllByOrderBySchoolName());
		//model.addAttribute("topic", topicRepository.findByTopicName(topic));
		//model.addAttribute("topics", topicRepository.findAllBySchoolID(school));
		model.addAttribute("threads", threadRepository.findAllByOrderByDateCreatedDesc());
		model.addAttribute("newPost", new Post());
		model.addAttribute("posts", postRepository.findAllByOrderByDateCreatedDesc());
		return topic;
	}

	@RequestMapping(value="school/{schoolID}/{topic}", method=RequestMethod.POST)
	public String postComment(Model model, @ModelAttribute Post newPost, @PathVariable("schoolID") String id, @PathVariable("topic") String topic) {
		
		//model.addAttribute("topic", topicRepository.findByTopicName(topic));
		java.util.Date date = new java.util.Date();
		School school = schoolRepository.findOne(id);
		Post post = new Post();
		User user = userRepository.findByUserName("mattdioso");
		Topic selectedTopic = topicRepository.findByTopicName(topic);
		Thread thread = new Thread();
		List<Post> posts = new ArrayList<Post>();
		List<Thread> threads = new ArrayList<Thread>();

		model.addAttribute("selectedSchool", school);
		//model.addAttribute("newPost", newPost);

		thread.setSchoolID(id);
		thread.setTopic(selectedTopic);
		thread.setUser(user);
		thread.setUserID(user.getId());
		thread.setDateCreated(new java.sql.Date(date.getTime()));
		threadRepository.save(thread);

		threads.add(thread);

		selectedTopic.setThreads(threads);

		post.setThread(thread);
		post.setCreatedBy(user.getUsername());
		post.setUser(user);
		post.setDateCreated(new java.sql.Date(date.getTime()));
		post.setContent(newPost.getContent());
		post.setPostName("test");
		postRepository.save(post);

		posts.add(post);
		thread.setPosts(posts);

		return "redirect:/school/" + id + "/" + topic;
	}

	
	
	@RequestMapping(value="school/{schoolID}/{topic}/{postID}/reply", method=RequestMethod.POST)
	public String replyComment(Model model, @ModelAttribute Post reply, @PathVariable("postID") String postID, @ModelAttribute Thread thread, @PathVariable("schoolID")String id, @PathVariable("topic")String topic) {
		//model.addAttribute("reply", new Post());
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		java.util.Date date = new java.util.Date();
		Post originalPost = postRepository.findById(postID);
		List<Post> posts = originalPost.getThread().getPosts();
		Post postReply = new Post();
		postReply.setThread(originalPost.getThread());
		postReply.setCreatedBy("mattdioso");
		postReply.setUser(userRepository.findByUserName("mattdioso"));
		postReply.setDateCreated(new java.sql.Date(date.getTime()));
		postReply.setContent(reply.getContent());
		postReply.setPostName("reply");
		posts.add(postReply);
		originalPost.getThread().setPosts(posts);
		postRepository.save(postReply);

		return "redirect:/school/" + id + "/" + topic;
	}
	
}