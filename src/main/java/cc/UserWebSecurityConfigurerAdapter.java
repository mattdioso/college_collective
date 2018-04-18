package cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class UserWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/webjarsjs/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr
			.inMemoryAuthentication()
				.withUser("user")
				.password("password").authorities("ROLE_USER")
				.and()
				.withUser("admin").password("adminpassword")
				.authorities("ROLE_USER", "ROLE_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/home**", "/login**", "/resources/**", "/templates/**", "/js/**", "/static/**", "/webjars/**", "/css/**", "/images/**", "/schools/**")
				.permitAll()//.anyRequest()//.authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.failureUrl("/login?error")
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/login?denied")
			.and()
				.csrf()
					.ignoringAntMatchers("/rest/**")
			.and()
				.sessionManagement().enableSessionUrlRewriting(false)
			.and()
				.headers().frameOptions().disable()
				;
	}
}