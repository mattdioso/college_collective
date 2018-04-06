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

@Entity
public class Posts extends BaseObject {
	
	@Column(nullable=false)
	private String thread_id;
	
	@Column(nullable=false)
	private String user_id;
	
	@Lob
	private String content;
	
	@Column
	private Date date_created;
	
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