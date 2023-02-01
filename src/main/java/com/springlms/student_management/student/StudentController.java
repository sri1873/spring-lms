package com.springlms.student_management.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/getAllStudent")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping("/getStudentbyId/{studentId}")
	public Student getStudentbyId(@PathVariable int studentId) {
		Student response = studentService.getStudentbyId(studentId);
		if (response == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return response;

	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ResponseEntity<Object> addStudent(@RequestBody Student student) {
		Student st = studentService.addStudent(student);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/deleteStudent/{studentId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable int studentId) {
		int st = studentService.deleteStudent(studentId);
		if (st == 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/updateStudent/{studentId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable int studentId, @RequestBody Student student) {
		int st = studentService.updateStudent(studentId, student);
		if (st == 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return ResponseEntity.noContent().build();
	}
}
