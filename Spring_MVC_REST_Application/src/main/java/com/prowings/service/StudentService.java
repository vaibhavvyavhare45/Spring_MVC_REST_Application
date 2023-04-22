package com.prowings.service;

import java.util.List;

import com.prowings.model.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

	public void deleteStudentById(int id);

	public void updateStudent(Student student);

	public List<Student> getStudentFilterByBranch(String branch);


}
