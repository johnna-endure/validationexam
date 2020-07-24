package com.aop.validationexam;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private Gson gson = new Gson();

	@Test
	public void mockMvcIsNotNull() {
		assertThat(mockMvc).isNotNull();
	}

	@Test
	public void post_기본테스트() throws Exception {
		Person person = new Person("name", 32);

		mockMvc.perform(
				post("/person")
						.contentType(MediaType.APPLICATION_JSON)
						.content(gson.toJson(person)))
				.andExpect(status().isOk())
				.andExpect(content().json(gson.toJson(person)));
	}
}
