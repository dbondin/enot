package ru.applmath.enot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.applmath.enot.repository.EnotUserRepository;

@Service
public class DefaultEnotUserService implements EnotUserService {
	
	@Autowired
	private EnotUserRepository enotUserRepository;
	
	@Transactional(readOnly = true)
	public long count() {
		return enotUserRepository.count();
	}
}
