package cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.ldap.core.support.AbstractContextSource;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import java.util.Base64;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
//import com.unboundid.ldap.sdk.migrate.ldapjdk.LDAPConnection;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;


@Configuration
@EnableWebSecurity
public class UserWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/webjarsjs/**");
	}

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr
			.inMemoryAuthentication()
				.withUser("user")
				.password("password").authorities("ROLE_USER")
				.and()
				.withUser("admin").password("adminpassword")
				.authorities("ROLE_USER", "ROLE_ADMIN");
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/**")
				//.antMatchers("/", "/home**", "/login**", "/resources/**", "/templates/**", "/js/**", "/static/**", "/webjars/**", "/css/**", "/images/**", "/schools/**")
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

	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=Student")
				.groupSearchBase("ou=Student")
				.contextSource(contextSource())
				.authoritiesMapper(setAuthorities())
				.passwordCompare()
				.passwordAttribute("userPassword")
				.and()
				.passwordEncoder(passwordEncoder());
	}
	
	//Embedded LDAP server
	/*@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=users")
				.groupSearchBase("ou=groups")
				.contextSource()
					.url("ldap://localhost:389/dc=school,dc=edu")
					.ldif("classpath:some-path.ldif")
					.root("dc=school,dc=edu")
					.and()
				.authoritiesMapper(setAuthorities())
				.passwordCompare()
				.passwordAttribute("userPassword")
				.and()
				.passwordEncoder(passwordEncoder());
	}*/

	private PasswordEncoder passwordEncoder() {
		final LdapShaPasswordEncoder sha = new LdapShaPasswordEncoder();
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return sha.encodePassword(rawPassword.toString(), null);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return sha.isPasswordValid(encodedPassword, rawPassword.toString(), null);
			}
		};
	}

	private SimpleAuthorityMapper setAuthorities() throws Exception {
		SimpleAuthorityMapper auths = new SimpleAuthorityMapper();
		auths.setDefaultAuthority("ROLE_USER");
		auths.afterPropertiesSet();
		return auths;
	}

	private LdapContextSource contextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl("ldap://localhost");
		contextSource.setBase("dc=college-collective, dc=com");
		contextSource.setUserDn("cn=root, dc=college-collective, dc=com");
		contextSource.setPassword("!Univega1986");
		contextSource.afterPropertiesSet();
		return contextSource;
	}
	
}