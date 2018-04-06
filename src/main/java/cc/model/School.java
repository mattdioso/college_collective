package cc.model;

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

@Entity
public class School extends BaseObject {

	@Column(nullable=false)
	private String school_name;

	@OneToMany(mappedBy="schools", cascade= {CascadeType.ALL})
	@OrderColumn(name="school_name")
	private List<School> schools;


	public String getSchoolName() {
		return school_name;
	}

	public void setSchoolName(String name) {
		this.school_name = name;
	} 

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools=schools;
	}
}