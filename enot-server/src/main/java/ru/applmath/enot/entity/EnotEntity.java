package ru.applmath.enot.entity;

import java.util.Date;

public interface EnotEntity {
	public Long getId();
	public Date getCreatedTimestamp();
	public Date getModifiedTimestamp();
	public boolean isActive();
}
