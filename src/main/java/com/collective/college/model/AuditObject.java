package com.collective.college.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@Audited
public abstract class AuditObject extends BaseObject {

	@CreatedDate
	@Column(updatable = false)//, columnDefinition="DATETIME")
	@Temporal(TemporalType.TIME)
	private Date dateCreated;

	@LastModifiedDate
	@Temporal(TemporalType.TIME)
	protected Date lastModifiedDate;

	@LastModifiedBy
	protected String lastModifiedBy;

	@CreatedBy
	@Column(updatable = false)
	protected String createdBy;

	public AuditObject() {
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date createdDate) {
		this.dateCreated = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
