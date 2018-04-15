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

import java.util.Date;
import java.util.List;

import org.hibernate.envers.Audited;

import cc.model.Posts;

@Entity
@Audited
public class Threads extends AuditObject {
	
	@Column(name = "topicName", nullable=false)
	private String topicName;

	@Column(name = "schoolName", nullable=false)
	private String schoolName;

	@Column(name = "userName", nullable=false)
	private String userName;

	@OneToMany(mappedBy="userName", cascade= {CascadeType.ALL})
	@OrderColumn(name="dateCreated")
	private List<Posts> posts;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String name) {
		this.topicName=name;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String name) {
		this.schoolName=name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName=name;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	public List<Posts> getPosts() {
		return posts;
	}
}