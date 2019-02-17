package com.collective.college.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.School;


public interface SchoolRepository extends PagingAndSortingRepository<School, String> {
	public List<School> findAllByOrderBySchoolName();
	public School findBySchoolName(String schoolName);
}