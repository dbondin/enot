package ru.applmath.enot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.applmath.enot.service.InitialUserCreatorService;

@SpringBootApplication
public class EnotApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnotApplication.class, args)
				.getBean(InitialUserCreatorService.class)
				.createInitialUserIfRequired();
	}

}
