package cc.service;

import java.io.ByteArrayInputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.support.LdapNameBuilder;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.Name;

import cc.web.vo.UserVO;
import cc.web.vo.ChangePasswordVO;

import org.springframework.stereotype.Service;

@Service
public class LdapService {

	public void createNewUser(UserVO userVo) {
		LdapTemplate ldapTemplate = new LdapTemplate(contextSource());
		PasswordEncoder encode = passwordEncoder();
		Name dn = LdapNameBuilder
			.newInstance()
			.add("ou", "Student")
			.add("uid", userVo.getUserName())
			.build();
		DirContextAdapter context = new DirContextAdapter(dn);

		context.setAttributeValues(
			"objectclass",
			new String[]
			{
				"top",
				"person",
				"organizationalPerson",
				"inetOrgPerson"
			});
		context.setAttributeValue("cn", userVo.getUserName());
		context.setAttributeValue("sn", userVo.getUserName());
		context.setAttributeValue("userPassword", encode.encode((CharSequence)userVo.getPassword()));
		ldapTemplate.bind(context);
	}

	public void changeUserPassword(ChangePasswordVO changePasswordVo) {
		LdapTemplate ldapTemplate = new LdapTemplate(contextSource());
		DirContextAdapter user = new DirContextAdapter();
		PasswordEncoder encode = passwordEncoder();

		user = (DirContextAdapter)ldapTemplate.lookup("uid=" + changePasswordVo.getUserName() + ",ou=Student");

		if (user == null) {
			System.out.println("User Not Found");
			return;
		}

		String encodedInput = encode.encode((CharSequence)changePasswordVo.getOldPassword());

		if (new String((byte[])user.getObjectAttribute("userPassword")).compareTo(encodedInput)!=0) {
			System.out.println("Bad Passwords");
			return;
		}

		String encodedNewPassword = encode.encode((CharSequence)changePasswordVo.getPassword());
		DirContextAdapter mod = new DirContextAdapter("uid=" + changePasswordVo.getUserName() + ",ou=Student");
		BasicAttribute attr = new BasicAttribute("userPassword", encodedNewPassword);
		ModificationItem[] modArray = new ModificationItem[1];
		modArray[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);

		ldapTemplate.modifyAttributes("uid=" + changePasswordVo.getUserName() + ",ou=Student", modArray);
	}

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