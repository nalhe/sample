package com.barclays.student.manager.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.student.manager.bean.Student;
import com.barclays.student.manager.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/{rollNumber}")
	public Student getStudent(@PathVariable("rollNumber") Integer rollNumber) {
		return studentService.getStudent(rollNumber);
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@PostMapping("/{rollNumber}")
	public Student updateStudent(@PathVariable("rollNumber") int rollNumber, @RequestBody Student student) {
		return studentService.updateStudent(rollNumber, student);
	}

	@DeleteMapping("/{rollNumber}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("rollNumber") int rollNumber) {
		studentService.deleteStudent(rollNumber);
	}
	
	@GetMapping
	public Collection<Student> listStudents(){
		return studentService.listStudents();
	}

}
