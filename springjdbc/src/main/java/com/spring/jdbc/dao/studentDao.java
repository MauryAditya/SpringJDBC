package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;
//2
public interface studentDao {
	public int insert(Student student);
	public int update(Student student);	
	public int delete(int studentdelete);
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();

}
