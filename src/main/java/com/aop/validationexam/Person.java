package com.aop.validationexam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Valid
@Getter @ToString
@RequiredArgsConstructor
public class Person {
	@NotNull(message = "name is null")
	private final String name;
	@Min(1)
	private final int age;
}
