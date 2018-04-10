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

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Topic extends BaseObject {

	@Column(name = "topicName", nullable=false)	
	private String topicName;

	@Column(name = "schoolName", nullable=false)
	private String schoolName;


	public void setTopicName(String name) {
		this.topicName=name;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setSchoolName(String name) {
		this.schoolName=name;
	}

	public String getSchoolName() {
		return schoolName;
	}
}