package com.aop.validationexam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonAspectTest {

	@Autowired
	private Validator validator;

	@Test
	public void validatorIsNotNull(){
		assertThat(validator).isNotNull();
	}

}
