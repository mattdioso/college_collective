package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.School;

public interface SchoolRepository extends RevisionRepository<School, String, Integer>, PagingAndSortingRepository<School, String> {
	public List<School> findAllOrderByName();
}