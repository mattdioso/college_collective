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

import org.hibernate.envers.Audited;

@Entity
@Audited
public class School extends BaseObject {

	@Column(name = "schoolName", nullable=false)
	private String schoolName;

	//@OneToMany(mappedBy="schools", cascade= {CascadeType.ALL})
	//@OrderColumn(name="schoolName")
	//private List<School> schools;


	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String name) {
		this.schoolName = name;
	} 

	/*public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools=schools;
	}*/
}