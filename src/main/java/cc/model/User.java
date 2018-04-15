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
public class User extends BaseObject {

	@Column(name= "userName", nullable=false)	
	private String userName;
	
	@Column(name = "userSchool", nullable=false)
	private String userSchool;
	
	@Column(name = "userEmail", nullable=false)
	private String userEmail;


	public void setUsername(String name) {
		this.userName=name;
	}

	public String getUsername() {
		return userName;
	}

	public void setUserSchool(String school) {
		this.userSchool=school;
	}

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserEmail(String email) {
		this.userEmail = email;
	}

	public String getUserEmail() {
		return userEmail;
	}
}