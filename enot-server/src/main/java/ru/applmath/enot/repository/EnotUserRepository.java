package ru.applmath.enot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.applmath.enot.entity.EnotUser;

public interface EnotUserRepository extends JpaRepository<EnotUser, Long>{
	Optional<EnotUser> findByName(String name);
}
