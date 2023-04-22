package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.exception.InSufficientDetailException;
import com.prowings.exception.StudentNotPresentException;
import com.prowings.model.Student;
import com.prowings.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public @ResponseBody String hello() {
		return "hello";
	}

	// @RequestMapping(value="/students",method=RequestMethod.POST)
	@PostMapping("/students")
	public @ResponseBody String saveStudent(@RequestBody Student student) throws InSufficientDetailException {

		try {
			studentService.saveStudent(student);
			return "Student sucessfully stored";
		}
		catch(Exception e) {
			throw new InSufficientDetailException("Insufficient detail!");
			
		}
		
	}

	@GetMapping("/students/{id}")
	public @ResponseBody Student getStudentById(@PathVariable("id") int id) throws StudentNotPresentException {

		Student stud = studentService.getStudentById(id);
		if (null != stud)
			return stud;
		else
			throw new StudentNotPresentException("student not present with id:" + id);

	}

	@GetMapping("/students")
	public @ResponseBody List<Student> getAllStudent() {
		return studentService.getAllStudents();
	}

	@DeleteMapping("/students/{id}")
	public @ResponseBody String deleteStudentById(@PathVariable("id") int id) {
		studentService.deleteStudentById(id);
		return "student deleted successfully";
	}

	@PutMapping("/updateStudent")
	public @ResponseBody String updateStudent(@RequestBody Student student) {

		studentService.updateStudent(student);

		return "Student updated successfully...";

	}

	@GetMapping("/students1")
	public List<Student> getStudentFilterByBranch(@RequestParam String branch) {
		List<Student> stdList = studentService.getStudentFilterByBranch(branch);
		return stdList;

	}

}