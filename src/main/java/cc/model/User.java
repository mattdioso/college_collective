package cc.model;

public class User {
	private String user_id;
	private String user_name;
	private String user_school;
	private String user_email;

	public void setUserId(String id) {
		user_id = id;
	}

	public String getUserId() {
		return user_id;
	}

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