package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Threads;


public interface ThreadRepository extends PagingAndSortingRepository<Threads, String> {
	public List<Threads> findAllByOrderByDateCreated();
	public List<Threads> findBySchoolNameAndTopicName(String schoolName, String topicName);
}