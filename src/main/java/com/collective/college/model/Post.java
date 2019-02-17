package com.collective.college.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import cc.model.Thread;
import cc.model.User;

import java.util.List;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Post extends AuditObject {
	@Column(name = "postName", nullable = false)
	private String postName;
	
	@ManyToOne
	private Thread thread;

	@ManyToOne
	private User user;

	
	@Lob
	private String content;

	public Post() {}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Thread getThread() {
		return thread;
	}

	public void setUser(User user) {
		this.user=user;
	}

	public User getUser() {
		return user;
	}

	public void setPostName(String postName) {
		this.postName=postName;
	}

	public String getPostName() {
		return postName;
	}

	public void setContent(String postContent) {
		this.content = postContent;
	}

	public String getContent() {
		return content;
	}
}