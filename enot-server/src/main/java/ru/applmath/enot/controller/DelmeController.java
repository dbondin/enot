package ru.applmath.enot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.applmath.enot.dto.DelmeDto;

@RestController
public class DelmeController {

	@RequestMapping(method=RequestMethod.GET, path="/delme")
	public DelmeDto delme() {
		final DelmeDto result = new DelmeDto();
		result.setStr("Hello");
		result.setI(23);
		result.setD(Math.PI);
		return result;
	}
}