package com.ayyappa.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayyappa.springsecurity.entities.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	private List<Student> students = new ArrayList<>(List.of(
			new Student(1,"Ramudu",80),
			new Student(2,"Seeta",90)
			));
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return students;
	}
	
	//of course we are using same url but mapping is different
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
	    students.add(student);
	    return student;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		
		return (CsrfToken)request.getAttribute("_csrf");	
	}
	
}
