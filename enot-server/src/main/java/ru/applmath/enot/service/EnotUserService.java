package ru.applmath.enot.service;

import java.util.Optional;

import ru.applmath.enot.entity.EnotUser;

public interface EnotUserService {
	public long count();
	public Optional<EnotUser> findByName(String name);
	public EnotUser save(final EnotUser user);
}
