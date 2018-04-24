package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.Post;

public interface PostRepository extends RevisionRepository<Post, String, Integer>, PagingAndSortingRepository<Post, String> {
	public List<Post> findAllByOrderByDateCreated();
	public Post findById(String id);
}