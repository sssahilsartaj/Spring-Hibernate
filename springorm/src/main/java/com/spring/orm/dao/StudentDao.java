package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Student;

public interface StudentDao {
	public int insertStudent(Student student);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
	public void deleteStudent(int studentId);
	public void updateStudent(Student student);

}
