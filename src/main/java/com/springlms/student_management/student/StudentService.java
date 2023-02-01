package com.springlms.student_management.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private static List<Student> students = new ArrayList<>();

	static {
		Student st1 = new Student(1, "sk@email.com", "password", "sri", "kumar", 1234567891l, true);
		Student st2 = new Student(2, "sk@email.com", "password", "rushi", "vardhan", 1234567891l, true);
		Student st3 = new Student(3, "sk@email.com", "password", "vaigarai", "sathi", 1234567891l, true);
		Student st4 = new Student(4, "sk@email.com", "password", "guna", "vardhan", 1234567891l, true);
		Student st5 = new Student(5, "sk@email.com", "password", "arun", "chandra", 1234567891l, true);
		Student st6 = new Student(6, "sk@email.com", "password", "aparna", "v", 1234567891l, true);
		students.add(st1);
		students.add(st2);
		students.add(st3);
		students.add(st4);
		students.add(st5);
		students.add(st6);
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public Student getStudentbyId(int studentId) {
		Optional<Student> student = students.stream().filter(st -> st.getStudentId() == studentId).findFirst();
		if (student.isPresent())
			return student.get();
		return null;
	}

	public Student addStudent(Student student) {
		students.add(student);
		return null;
	}

	public int deleteStudent(int studentId) {
		Predicate<? super Student> filter = st -> st.getStudentId() == studentId;
		boolean removed = students.removeIf(filter);
		if (!removed)
			return 0;
		return studentId;

	}

	public int updateStudent(int studentId, Student student) {
		Student st = getStudentbyId(studentId);
		if (st == null)
			return 0;
		students.removeIf(std -> std.getStudentId() == studentId);
		students.add(student);
		return 1;
	}

}
