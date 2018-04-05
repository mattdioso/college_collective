package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Topic;

public interface TopicRepository extends RevisionRepository<Topic, String, Integer>, PagingAndSortingRepository<Topic, String> {
	public List<Topic> findBySchoolID(String school_id);
}