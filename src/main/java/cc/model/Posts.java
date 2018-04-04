package cc.model;

import java.util.Date;

public class Posts {
	private String post_id;
	private String thread_id;
	private String user_id;
	private String content;
	private Date date_created;

	public void setPostID(String postID) {
		this.post_id = postID;
	}

	public String getPostID() {
		return post_id;
	}

	public void setthreadID(String postID) {
		this.thread_id = postID;
	}

	public String getThreadID() {
		return thread_id;
	}

	public void setUserID(String postID) {
		this.user_id = postID;
	}

	public String getUserID() {
		return user_id;
	}

	public void setPostContent(String postContent) {
		this.content = postContent;
	}

	public String getPostContent() {
		return content;
	}

	public void setDateCreated(Date dateCreated) {
		this.date_created = dateCreated;
	}

	public Date getDateCreated() {
		return date_created;
	}
}