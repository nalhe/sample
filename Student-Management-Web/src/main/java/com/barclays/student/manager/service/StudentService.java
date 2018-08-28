package com.barclays.student.manager.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.barclays.student.manager.bean.Student;

@Service
public class StudentService {

	private Map<Integer, Student> studentDB = new HashMap<Integer, Student>();

	public Map<Integer, Student> getStudentDB() {
		return studentDB;
	}

	public void setStudentDB(Map<Integer, Student> studentDB) {
		this.studentDB = studentDB;
	}

	public Student getStudent(int rollNumber) {
		return studentDB.get(rollNumber);
	}

	public Student addStudent(Student student) {
		studentDB.put(student.getRollNumber(), student);
		return student;
	}

	public Student updateStudent(int rollNumber, Student student) {
		if (studentDB.get(rollNumber) != null) {
			studentDB.put(rollNumber, student);
			return student;
		}
		return null;
	}

	public boolean deleteStudent(int rollNumber) {
		if (studentDB.get(rollNumber) != null) {
			studentDB.remove(rollNumber);
			return true;
		}
		return false;
	}

	public Collection<Student> listStudents() {
		return studentDB.values();
	}

}
