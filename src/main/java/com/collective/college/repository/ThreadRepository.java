package com.collective.college.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Thread;


public interface ThreadRepository extends RevisionRepository<Thread, String, Integer>, PagingAndSortingRepository<Thread, String> {
	public List<Thread> findAllByOrderByDateCreatedDesc();
	//public List<Threads> findBySchoolIDAndTopicID(String schoolID, String topicID);
}