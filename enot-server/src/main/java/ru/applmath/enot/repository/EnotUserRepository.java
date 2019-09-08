package ru.applmath.enot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.applmath.enot.entity.EnotUser;

public interface EnotUserRepository extends JpaRepository<EnotUser, Long>{

}
