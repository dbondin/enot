package ru.applmath.enot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "enot_user")
@SequenceGenerator(name = AbstractEnotEntity.ID_SEQUENCE_GENERATOR_NAME, sequenceName = "enot_user_id_seq", allocationSize = 1)
public class EnotUser extends AbstractEnotEntity {

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "password", nullable = false, unique = false)
	private String password;

	@Column(name = "admin", nullable = false, unique = false)
	private boolean admin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
