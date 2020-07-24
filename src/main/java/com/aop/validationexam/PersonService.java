package com.aop.validationexam;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service
public class PersonService {
	private List<Person> personList = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(PersonService.class);

	public Person save(Person person) {
		logger.info("save 호출됨.");
		personList.add(person);
		return person;
	}
}
