package cc.model;

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

import java.util.Date;
import java.util.List;

import org.hibernate.envers.Audited;

import cc.model.Post;
import cc.model.Topic;
import cc.model.User;

@Entity
@Audited
public class Thread extends AuditObject {
	
	/*@Column(name = "topicID", nullable=false)
	private String topicID;*/

	@Column(name = "schoolID", nullable=false)
	private String schoolID;

	@Column(name = "userID", nullable=false)
	private String userID;

	@ManyToOne
	//@JoinColumn(name="id", insertable=false, updatable=false, nullable=false)
	private Topic topic;

	@ManyToOne
	//@JoinColumn(name="id", insertable=false, updatable=false, nullable=false)
	private User user;



	@OneToMany(mappedBy="thread", cascade= {CascadeType.ALL})
	@OrderColumn(name="dateCreated")
	private List<Post> posts;

	public Thread() {}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic=topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user=user;
	}
	/*public String getTopicID() {
		return topicID;
	}

	public void setTopicID(String name) {
		this.topicID=name;
	}*/

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String name) {
		this.schoolID=name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String name) {
		this.userID=name;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Post> getPosts() {
		return posts;
	}
}