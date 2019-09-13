package ru.applmath.enot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.applmath.enot.entity.EnotUser;
import ru.applmath.enot.service.EnotUserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class EnotUserDetailsService implements UserDetailsService {

	@Autowired
	private EnotUserService enotUserService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		//@formatter:off
		EnotUser user = enotUserService
				.findByName(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		//@formatter:on

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.isAdmin() ? EnotRole.ADMIN : EnotRole.USER));

		final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		return User.withUsername(user.getName())
				.password(encoder.encode(user.getPassword()))
				.roles(user.isAdmin() ? EnotRole.ADMIN : EnotRole.USER)
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(!user.isActive())
				.build();
	}

}
