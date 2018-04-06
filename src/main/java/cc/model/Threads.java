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

import java.util.Date;
import java.util.List;

import cc.model.Posts;

@Entity
public class Threads extends BaseObject {
	
	@Column(nullable=false)
	private String topic_id;

	@Column(nullable=false)
	private String school_id;

	@Column
	private Date date_created;

	@Column(nullable=false)
	private String user_id;

	@OneToMany(mappedBy="user_id", cascade= {CascadeType.ALL})
	@OrderColumn(name="date_created")
	private List<Posts> posts;


	public String getTopicID() {
		return topic_id;
	}

	public void setTopicID(String id) {
		this.topic_id=id;
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