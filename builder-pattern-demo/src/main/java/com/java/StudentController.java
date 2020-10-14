package com.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.model.Student;
import com.java.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@PostMapping("/student")
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Student createStudent(@RequestBody StudentDto studentDto) {

		Student student = new Student.Builder().setName(studentDto.getName()).setActive(studentDto.isActive()).build();
		return repository.save(student);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/students")
	public @ResponseBody List<Student> getAllStudents() {

		return repository.findAll();

	}
}
