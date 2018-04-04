package cc.model;

import java.util.Date;
import java.util.List;
import cc.model.Posts;

public class Threads {
	private String thread_id;
	private String subject_id;
	private String school_id;
	private Date date_created;
	private String user_id;
	private List<Posts> posts;

	public String getThreadID() {
		return thread_id;
	}

	public void setThreadID(String id) {
		this.thread_id=id;
	}

	public String getSubjectID() {
		return subject_id;
	}

	public void setSubjectID(String id) {
		this.subject_id=id;
	}

	public String getSchoolID() {
		return school_id;
	}

	public void setSchoolID(String id) {
		this.school_id=id;
	}

	public String getUserID() {
		return user_id;
	}

	public void setUserID(String id) {
		this.user_id=id;
	}

	public Date getDateCreated() {
		return date_created;
	}

	public void setDateCreated(Date date) {
		this.date_created=date;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	public List<Posts> getPosts() {
		return posts;
	}
}