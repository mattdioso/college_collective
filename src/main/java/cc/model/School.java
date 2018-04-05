package cc.model;

import java.util.List;

public class School {
	private String school_id;
	private String school_name;
	private List<School> schools;

	public String getSchoolId() {
		return school_id;
	}

	public void setSchoolId(String Id) {
		school_id=Id;
	}

	public String getSchoolName() {
		return school_name;
	}

	public void setSchoolName(String name) {
		school_name = name;
	} 

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools=schools;
	}
}