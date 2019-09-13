package ru.applmath.enot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.applmath.enot.entity.EnotUser;
import ru.applmath.enot.repository.EnotUserRepository;

@Service
public class DefaultEnotUserService implements EnotUserService {
	
	@Autowired
	private EnotUserRepository enotUserRepository;
	
	@Override
	@Transactional(readOnly = true)
	public long count() {
		return enotUserRepository.count();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<EnotUser> findByName(final String name) {
		return enotUserRepository.findByName(name);
	}
	
	@Override
	@Transactional(readOnly = false)
	public EnotUser save(final EnotUser user) {
		return enotUserRepository.save(user);
	}
}
