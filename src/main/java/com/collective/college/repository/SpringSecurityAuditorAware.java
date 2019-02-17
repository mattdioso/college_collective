package com.collective.college.repository;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SpringSecurityAuditorAware implements AuditorAware<String> {
	public String getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication==null || authentication.isAuthenticated()) {
			return null;
		}

		if (authentication.getPrincipal() instanceof UserDetails) {
			return ((UserDetails)authentication.getPrincipal()).getUsername();
		}

		return authentication.getPrincipal().toString();
	}
}