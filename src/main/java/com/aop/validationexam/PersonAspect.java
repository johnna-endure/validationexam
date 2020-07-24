package com.aop.validationexam;

import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@RequiredArgsConstructor
@Component
@Aspect
public class PersonAspect {

	private static Logger logger = LoggerFactory.getLogger(PersonAspect.class);
	private final Validator validator;

	@Pointcut("within(com.aop.validationexam.PersonService) && @args(javax.validation.Valid)")
	public void validationPointcut(){ }

	@Before("validationPointcut() && args(param)")
	public void validatePerson(Object param) {
		logger.info("validation 호출됨.");
		Set<ConstraintViolation<Object>> violationSet = validator.validate(param);
		JsonObject jsonObject = new JsonObject();
		violationSet.stream().forEach(c -> {
			jsonObject.addProperty(c.getPropertyPath().toString(), c.getMessage());
		});
		String desc = jsonObject.toString();
		logger.info(desc);
		if(jsonObject.size() != 0)throw new ValidationException(desc);
	}
}
