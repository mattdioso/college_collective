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
import javax.persistence.JoinColumn;

import java.util.List;

import cc.model.Thread;
import cc.model.School;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Topic extends BaseObject {

	@Column(name = "topicName", nullable=false)	
	private String topicName;

	/*@Column(name = "schoolID", nullable=false)
	private String schoolID;*/

	@ManyToOne
	//@JoinColumn(name="id", insertable=false, updatable=false, nullable=false)
	private School school;

	@OneToMany(mappedBy="topic", cascade= {CascadeType.ALL})
	@OrderColumn(name="dateCreated")
	private List<Thread> threads;

	public void setSchool(School school) {
		this.school=school;
	}

	public School getSchool() {
		return school;
	}

	public void setTopicName(String name) {
		this.topicName=name;
	}

	public String getTopicName() {
		return topicName;
	}

	/*public void setSchoolID(String name) {
		this.schoolID=name;
	}

	public String getSchoolID() {
		return schoolID;
	}*/

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads=threads;
	}
}