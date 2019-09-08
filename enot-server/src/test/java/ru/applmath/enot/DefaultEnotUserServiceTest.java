package ru.applmath.enot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ru.applmath.enot.service.DefaultEnotUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DefaultEnotUserServiceTest {
	
	@Autowired
	private DefaultEnotUserService defaultEnotUserService;
	
	@Test
	public void countTest() {
		assertEquals(defaultEnotUserService.count(), 0);
	}
}
