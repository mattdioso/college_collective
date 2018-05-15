package cc.web.vo;

import javax.validation.constraints.NotNull;

import cc.service.ValidEmail;
import cc.service.PasswordMatches;

@PasswordMatches
public class ChangePasswordVO {

	@NotNull
	protected String userName;

	@ValidEmail
	@NotNull
	protected String userEmail;

	@NotNull
	protected String newPassword;

	@NotNull
	protected String password;

	@NotNull
	protected String matchingPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail=userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword=matchingPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}
}