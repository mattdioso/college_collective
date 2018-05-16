package cc.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cc.web.vo.UserVO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserVO user = (UserVO) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}
}