package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private HibernateTemplate hibernateTemplate;
	
	// save or insert student object
	@Transactional
	public int insertStudent(Student student) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// get the single data (object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	// get all students (all rows)
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	// delete student by student id
	@Transactional
	public void deleteStudent(int studentId) {
		// first get the student object
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		// delete this student
		this.hibernateTemplate.delete(student);
	}
	
	// update student
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
		
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


}
