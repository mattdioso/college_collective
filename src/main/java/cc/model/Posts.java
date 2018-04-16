package cc.model;

import java.util.Date;

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

import cc.model.Threads;
import cc.model.User;

import java.util.List;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Posts extends AuditObject {
	@Column(name = "postName", nullable = false)
	private String postName;

	/*@Column(name = "threadID", nullable=false)
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private String threadID;*/
	
	@ManyToOne
	@JoinColumn(name="id", insertable=false, updatable=false, nullable=false)
	private Threads thread;

	@ManyToOne
	@JoinColumn(name="id", insertable=false, updatable=false, nullable=false)
	private User user;

	/*@Column(name = "userID", nullable=false)
	private String userID;*/
	
	@Lob
	private String content;

	/*public void setThreadID(String threadName) {
		this.threadID=threadName;
	}

	public String getThreadID() {
		return threadID;
	}*/

	public void setThread(Threads thread) {
		this.thread = thread;
	}

	public Threads getThread() {
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

	/*public void setUserID(String userName) {
		this.userID=userName;
	}

	public String getUserID() {
		return userID;
	}*/

	public void setPostContent(String postContent) {
		this.content = postContent;
	}

	public String getPostContent() {
		return content;
	}
}