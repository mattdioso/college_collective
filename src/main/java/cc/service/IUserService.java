package cc.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cc.model.User;
import cc.web.vo.UserVO;
import cc.model.PasswordResetToken;
import cc.model.VerificationToken;

public interface IUserService {

	User registerNewUserAccount(UserVO userVO);

	User getUser(String verificationToken);

	void saveRegisteredUser(User user);

	void deleteUser(User user);

	void createVerificationTokenForUser(User user, String token);

	VerificationToken getVerificationToken(String verificationToken);

	VerificationToken generateNewVerificationToken(String token);

	void createPasswordResetTokenForUser(User user, String token);

	PasswordResetToken getPasswordResetToken(String token);

	User getUserByPasswordResetToken(String token);

	User findUserByEmail(String email);

	User getUserById(String id);

	void changeUserPassword(User user, String password);

	boolean checkIfValidOldPassword(User user, String password);

	String validateVerificationToken(String token);

	/*String generateQRUrl(User user) throws UnsupportedEncodingException;*/

	/*User updateUser2FA(boolean use2FA);*/

	List<String> getUsersFromSessionRegistry();
}