package cc.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cc.repository.UserRepository;
import cc.model.User;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void initialize(ValidUsername constraintAnnotation) {}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		return (validateUserName(userName));
	}

	private boolean validateUserName(String userName) {
		User user = userRepository.findByUserName(userName);

		return (user == null ? true : false);
	}
}