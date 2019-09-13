package ru.applmath.enot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "enot")
public class EnotConfigurationProperties {

	public static final class DefaultUser {

		private String name;

		private String password;

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
	}

	private DefaultUser defaultUser;

	public DefaultUser getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(DefaultUser defaultUser) {
		this.defaultUser = defaultUser;
	}
}
