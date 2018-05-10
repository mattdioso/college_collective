package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Topic;

public interface TopicRepository extends PagingAndSortingRepository<Topic, String> {
	public Topic findByTopicName(String topicName);
	//public List<Topic> findAllBySchoolID(String schoolID);
}