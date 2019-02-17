package com.collective.college.model;

import java.util.List;

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

import cc.model.Topic;

import java.util.List;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class School extends BaseObject {

	@Column(name = "schoolName", nullable=false)
	private String schoolName;

	@OneToMany(mappedBy="school", cascade= {CascadeType.ALL})
	@OrderColumn(name="topicName")
	private List<Topic> topics;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String name) {
		this.schoolName = name;
	} 

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics=topics;
	}
}