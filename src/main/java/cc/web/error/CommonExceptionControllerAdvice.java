package cc.web.error;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import cc.web.error.UserAlreadyExistException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionControllerAdvice extends ResponseEntityExceptionHandler {
	
	public CommonExceptionControllerAdvice() {
		super();
	}

	//400 errors
	@ExceptionHandler({ConstraintViolationException.class})
	public ModelAndView handleBadRequest(final ConstraintViolationException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "Bad request. Our engineers have been made aware and are working on it";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}

	@ExceptionHandler({DataIntegrityViolationException.class})
	public ModelAndView handleBadRequest(final DataIntegrityViolationException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "Some unknown error has occurred, our engineers are working hard to decipher it";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}
	
	public ModelAndView handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "Some unknown error has occurred, our engineers are working hard to decipher it";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}

	public ModelAndView handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "Something went wrong, we're working on it";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}

	//404
	@ExceptionHandler(value = {EntityNotFoundException.class, UserAlreadyExistException.class})
	public ModelAndView handleNotFound(final RuntimeException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "Looks like this user already exists! Ha";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}

	//409
	@ExceptionHandler({InvalidDataAccessApiUsageException.class, DataAccessException.class})
	public ModelAndView handleConflict(final RuntimeException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "You do not have permission to access these things";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}

	//500
	@ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class})
	public ModelAndView handleInternal(final RuntimeException ex, final HttpServletRequest request) {
		final String bodyOfResponse = "Some internal error occured, we're working on it";
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.addObject("bodyOfResponse", bodyOfResponse);
		mav.setViewName("error");

		return mav;
	}
}