package com.collective.college.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import cc.repository.PasswordResetTokenRepository;
import cc.repository.VerificationTokenRepository;
import cc.repository.UserRepository;

import cc.model.PasswordResetToken;
import cc.model.VerificationToken;
import cc.model.User;

import cc.web.vo.UserVO;
import cc.web.vo.ChangePasswordVO;

import cc.service.LdapService;

import cc.web.error.UserAlreadyExistException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Autowired
	private PasswordResetTokenRepository passwordTokenRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SessionRegistry sessionRegistry;

	@Autowired
	private LdapService ldapService;

	public static final String TOKEN_INVALID = "invalidToken";

	public static final String TOKEN_EXPIRED = "expired";

	public static final String TOKEN_VALID = "valid";

	@Override
	public User registerNewUserAccount(final UserVO userVo) {
		if (emailExist(userVo.getUserEmail()))
			throw new UserAlreadyExistException("There is an account with that email address: " + userVo.getUserEmail());

		final User user = new User();

		user.setUsername(userVo.getUserName());
		user.setUserSchool(userVo.getUserSchool());
		user.setUserEmail(userVo.getUserEmail());
		ldapService.createNewUser(userVo);
		return userRepository.save(user);
	}

	@Override
	public User getUser(final String verificationToken) {
		final VerificationToken token = getVerificationToken(verificationToken);
		if (token !=null)
			return token.getUser();
		return null;
	}

	@Override
	public VerificationToken getVerificationToken(final String verificationToken) {
		return tokenRepository.findByToken(verificationToken);
	}

	@Override
	public void saveRegisteredUser(final User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(final User user) {
		final VerificationToken verificationToken = tokenRepository.findByUser(user);

		if (verificationToken != null)
			tokenRepository.delete(verificationToken);

		final PasswordResetToken passwordToken = passwordTokenRepository.findByUser(user);

		if (passwordToken != null)
			passwordTokenRepository.delete(passwordToken);

		userRepository.delete(user);
	}

	@Override
	public void createVerificationTokenForUser(final User user, final String token) {
		final VerificationToken myToken = new VerificationToken(token, user);
		tokenRepository.save(myToken);
	}

	@Override
	public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
		VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
		vToken.updateToken(UUID.randomUUID().toString());
		vToken = tokenRepository.save(vToken);
		return vToken;
	}

	@Override
	public void createPasswordResetTokenForUser(final User user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordTokenRepository.save(myToken);
	}

	@Override
	public User findUserByEmail(final String email) {
		return userRepository.findByUserEmail(email);
	}

	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordTokenRepository.findByToken(token);
	}

	@Override
	public User getUserByPasswordResetToken(final String token)	 {
		return passwordTokenRepository.findByToken(token).getUser();
	}

	@Override
	public User getUserById(final String id) {
		return userRepository.findOne(id);
	}

	@Override
	public void changeUserPassword(ChangePasswordVO changePasswordVO) {
		//add implementation for change LDAP password
		ldapService.changeUserPassword(changePasswordVO);
	}

	@Override
	public boolean checkIfValidOldPassword(final User user, final String oldPassword) {
		//add implementation for comparing old passwords
		return true;
	}

	@Override
	public String validateVerificationToken(String token) {
		final VerificationToken verificationToken = tokenRepository.findByToken(token);
		if (verificationToken == null)
			return TOKEN_INVALID;

		final User user = verificationToken.getUser();
		final Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime())<= 0) {
			tokenRepository.delete(verificationToken);
			return TOKEN_EXPIRED;
		}

		//user.setEnabled(true);
		userRepository.save(user);
		return TOKEN_VALID;
	}

	/*@Override
    public String generateQRUrl(User user) throws UnsupportedEncodingException {
        return QR_PREFIX + URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME, user.getEmail(), user.getSecret(), APP_NAME), "UTF-8");
    }*/

   /* @Override
    public User updateUser2FA(boolean use2FA) {
        final Authentication curAuth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) curAuth.getPrincipal();
        currentUser.setUsing2FA(use2FA);
        currentUser = repository.save(currentUser);
        final Authentication auth = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(), curAuth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return currentUser;
    }*/

    private boolean emailExist(final String email) {
    	return userRepository.findByUserEmail(email) != null;
    }

    @Override
    public List<String> getUsersFromSessionRegistry() {
    	return sessionRegistry.getAllPrincipals().stream().filter((u) -> !sessionRegistry.getAllSessions(u, false).isEmpty()).map(Object::toString).collect(Collectors.toList());
    }
}