package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Topic;

public interface TopicRepository extends PagingAndSortingRepository<Topic, String> {
	public List<Topic> findByTopicName(String topicName);
}