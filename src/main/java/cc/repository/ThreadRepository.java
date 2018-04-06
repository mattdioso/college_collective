package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Threads;

public interface ThreadRepository extends RevisionRepository<Threads, String, Integer>, PagingAndSortingRepository<Threads, String> {
	public List<Threads> findBySchool_IDAndTopic_ID(String school_id, String topic_id);
}