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
public class User extends BaseObject {

	@Column(nullable=false)	
	private String user_name;
	
	@Column(nullable=false)
	private String user_school;
	
	@Column
	private String user_email;


	public void setUsername(String name) {
		user_name=name;
	}

	public String getUsername() {
		return user_name;
	}

	public void setUserSchool(String school) {
		user_school=school;
	}

	public String getUserSchool() {
		return user_school;
	}

	public void setUserEmail(String email) {
		user_email = email;
	}

	public String getUserEmail() {
		return user_email;
	}
}