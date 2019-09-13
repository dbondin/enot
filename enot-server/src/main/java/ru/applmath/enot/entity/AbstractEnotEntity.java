package ru.applmath.enot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class AbstractEnotEntity implements EnotEntity {

	public static final String ID_SEQUENCE_GENERATOR_NAME = "AbstractEnotEntityIdSecuenceGenerator";
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQUENCE_GENERATOR_NAME)
	private Long id;
	
	@Column(name = "active", nullable = false, unique = false)
	private boolean active;
	
	@Column(name = "created_timestamp", nullable = false, unique = false, updatable = false)
	private Date createdTimestamp;
	
	@Column(name = "modified_timestamp", nullable = false, unique = false)
	private Date modifiedTimestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	
	@PrePersist
	public void onPrePersist() {
		final Date currentDate = new Date();
		setCreatedTimestamp(currentDate);
		setModifiedTimestamp(currentDate);
	}

	@PreUpdate
	public void onPreUpdate() {
		final Date currentDate = new Date();
		setModifiedTimestamp(currentDate);
	}
}
