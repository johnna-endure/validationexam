package com.aop.validationexam;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PersonController {

	private final PersonService personService;

	@PostMapping("/person")
	public Person post(@RequestBody Person person){
		return personService.save(person);
	}
}
