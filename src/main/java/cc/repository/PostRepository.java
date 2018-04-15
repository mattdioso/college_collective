package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Posts;

public interface PostRepository extends RevisionRepository<Posts, String, Integer>, PagingAndSortingRepository<Posts, String> {
	public List<Posts> findAllByOrderByDateCreated();
}