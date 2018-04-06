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

@Entity
public class Topic extends BaseObject {

	@Column(nullable=false)	
	private String topic_name;

	@Column(nullable=false)
	private String school_id;


	public void setTopicName(String name) {
		this.topic_name=name;
	}

	public String getTopicName() {
		return topic_name;
	}

	public void setSchoolID(String id) {
		this.school_id = id;
	}

	public String getSchoolID() {
		return school_id;
	}
}