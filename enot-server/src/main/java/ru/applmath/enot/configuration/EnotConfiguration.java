package ru.applmath.enot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.applmath.enot.security.EnotUserDetailsService;

@Configuration
public class EnotConfiguration {

	@Bean
	public PasswordEncoder enotPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider enotAuthenticationProvider(@Autowired PasswordEncoder enotPasswordEncoder,
			@Autowired EnotUserDetailsService enotUserDetailsService) {
		DaoAuthenticationProvider daoAP = new DaoAuthenticationProvider() {
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				// TODO Auto-generated method stub
				return super.authenticate(authentication);
			}
		};
		daoAP.setPasswordEncoder(enotPasswordEncoder);
		daoAP.setUserDetailsService(enotUserDetailsService);
		return daoAP;
	}
}
