package com.barclays.student.manager.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.barclays.student.manager.bean.Student;
import com.barclays.student.manager.service.StudentService;

public class StudentControllerTest {
	private StudentController studentController;
	
	@Before
	public void createMock(){
		studentController = new StudentController();
		studentController.setStudentService(getMockedStudentService());
	}

	private StudentService getMockedStudentService() {
		return new StudentService() {
			public Student getStudent(int rollNumber) {
				Student student = new Student();
				student.setRollNumber(1);
				return student;
			}
		};
	}
	
	@Test
	public void test_getStudent_toReturnStudent_WhenInvokedWithRollNum(){
		Student student = studentController.getStudent(1);
		Assert.assertEquals(1, student.getRollNumber());		
	}
	
}
