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

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Posts extends AuditObject {
	@Column(name = "postName", nullable = false)
	private String postName;

	@Column(name = "threadName", nullable=false)
	private String threadName;
	
	@Column(name = "userName", nullable=false)
	private String userName;
	
	@Lob
	private String content;

	public void setThreadName(String threadName) {
		this.threadName=threadName;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setPostName(String postName) {
		this.postName=postName;
	}

	public String getPostName() {
		return postName;
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
}