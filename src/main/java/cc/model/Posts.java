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

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Posts extends BaseObject {
	
	@Column(name = "threadName", nullable=false)
	private String threadName;
	
	@Column(name = "userName", nullable=false)
	private String userName;
	
	@Lob
	private String content;
	
	@Column(name = "dateCreated")
	private Date dateCreated;

	public void setThreadName(String threadName) {
		this.threadName=threadName;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPostContent(String postContent) {
		this.content = postContent;
	}

	public String getPostContent() {
		return content;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
}