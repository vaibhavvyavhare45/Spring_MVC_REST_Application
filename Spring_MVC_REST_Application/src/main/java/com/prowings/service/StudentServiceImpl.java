package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentDao;
import com.prowings.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Override
	public Student getStudentById(int id) {

		return studentDao.getStudentById(id);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentDao.getAllStudents();
	}

	@Override
	public void deleteStudentById(int id) {

		studentDao.deleteStudentById(id);

	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);

	}

	@Override
	public List<Student> getStudentFilterByBranch(String branch) {
		// TODO Auto-generated method stub
		return studentDao.getStudentFilterByBranch(branch);
	}

	

}
