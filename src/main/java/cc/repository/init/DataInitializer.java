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

	public ResultSet getSchools() throws SQLException {
		Connection connection = db.connect();
		String sql = "select * from school";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getUsers() throws SQLException {
		Connection connection = db.connect();
		String sql = "select * from user";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getPosts() throws SQLException {
		Connection connection = db.connect();
		String sql = "select * from posts";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getThreads() throws SQLException {
		Connection connection = db.connect();
		String sql = "select * from threads";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	public ResultSet getTopics() throws SQLException {
		Connection connection = db.connect();
		String sql = "select * from topic";
		PreparedStatement statement = null;
		statement = connection.prepareStatement(sql);
		return statement.executeQuery();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void afterPropertiesSet() throws Exception {}

	@Async
	public void inialize() {

	}
}