package ru.applmath.enot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.applmath.enot.configuration.EnotConfigurationProperties;
import ru.applmath.enot.entity.EnotUser;

@Service
public class InitialUserCreatorService {
	
	private final Logger logger = LoggerFactory.getLogger(InitialUserCreatorService.class);
	
	@Autowired
	private EnotUserService enotUserService;
	
	@Autowired
	private EnotConfigurationProperties enotConfigurationProperties;
	
	public void createInitialUserIfRequired() {
		
		logger.info("Checking if any users exists");
		
		if(enotUserService.count() == 0) {
			
			logger.info("Trying to create default user");
			
			final EnotUser user = new EnotUser();
			user.setName(enotConfigurationProperties.getDefaultUser().getName());
			user.setPassword(enotConfigurationProperties.getDefaultUser().getPassword());
			user.setActive(true);
			user.setAdmin(true);
			enotUserService.save(user);
		}
	}
}
