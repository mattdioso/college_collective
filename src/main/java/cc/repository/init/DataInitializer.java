package cc.repository.init;

import java.io.IOException;
import java.util.*;

import cc.model.*;
import cc.repository.*;
import cc.service.DBConnectionManager;
import org.apache.commons.io.IOUtils;

import java.sql.*;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "data.initializer")
public class DataInitializer implements InitializingBean {

	@Autowired
	protected PostRepository postRepository;

	@Autowired
	protected SchoolRepository schoolRepository;

	@Autowired
	protected ThreadRepository threadRepository;

	@Autowired
	protected TopicRepository topicRepository;

	@Autowired
	protected UserRepository userRepository;

	private DBConnectionManager db;

	public ResultSet getSchools(Connection connection) throws SQLException {
		String sql = "select * from school";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getUsers(Connection connection) throws SQLException {
		String sql = "select * from user";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getPosts(Connection connection) throws SQLException {
		String sql = "select * from posts";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getThreads(Connection connection) throws SQLException {
		String sql = "select * from threads";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getTopics(Connection connection) throws SQLException {
		String sql = "select * from topic";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Async
	public void initialize() {
		SecurityContextHolder.setContext(createSecurityContext());
		Connection connection = db.connect();
		try {
			ResultSet rs = null;
			rs = getSchools(connection);
			while (rs.next()) {
				School school = new School();
				String id = rs.getString("id");
				String name = rs.getString("school_name");
				school.setId(id);
				school.setSchoolName(name);
				School q = schoolRepository.findBySchoolName(name);
				if (q != null)
					schoolRepository.save(school);
			}

			rs = getUsers(connection);
			while (rs.next()) {
				User user = new User();
				String id = rs.getString("id");
				String email = rs.getString("user_email");
				String name = rs.getString("user_name");
				String school = rs.getString("user_school");
				user.setId(id);
				user.setUserEmail(email);
				user.setUsername(name);
				user.setUserSchool(school);
				userRepository.save(user);
			}

			rs = getPosts(connection);
			while(rs.next()) {
				Posts post = new Posts();
				post.setId(rs.getString("id"));
				//post.setDateCreated(rs.getString("date_created"));
				post.setPostName(rs.getString("post_name"));
				post.setThreadName(rs.getString("thread_name"));
				post.setUserName(rs.getString("user_name"));
				post.setPostContent(rs.getString("content"));
				postRepository.save(post);
			}

			rs = getTopics(connection);
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getString("id"));
				topic.setSchoolName(rs.getString("school_name"));
				topic.setTopicName(rs.getString("topic_name"));
				topicRepository.save(topic);
			}

			rs = getThreads(connection);
			while (rs.next()) {
				Threads thread = new Threads();
				thread.setId(rs.getString("id"));
				thread.setSchoolName(rs.getString("school_name"));
				//thread.setDateCreated(rs.getString("date_created"));
				thread.setTopicName(rs.getString("topic_name"));
				thread.setUserName(rs.getString("user_name"));
				threadRepository.save(thread);
			} 
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			db.disconnect(connection);
		}
	}

	private SecurityContext createSecurityContext() {
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken("system", "system", authorities);
		context.setAuthentication(authentication);
		return context;
	}
}