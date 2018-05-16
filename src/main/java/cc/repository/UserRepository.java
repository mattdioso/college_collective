package cc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

import cc.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	public List<User> findAllByOrderByUserName();
	public User findByUserName(String userName);
	public User findByUserEmail(String email);
}