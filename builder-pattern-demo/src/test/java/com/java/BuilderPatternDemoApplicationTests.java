package com.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.java.model.Student;

@SpringBootTest
@RunWith(SpringRunner.class)
class BuilderPatternDemoApplicationTests {

	@Test
	void insert() {
		String url = "http://localhost:8080/api/student";
		StudentDto dto = new StudentDto();
		dto.setActive(true);
		dto.setName("SUNIL");
		HttpEntity<StudentDto> request = new HttpEntity<StudentDto>(dto);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Student> response = template.postForEntity(url, request, Student.class);
		assertEquals(201, response.getStatusCodeValue());
		
	}

}
