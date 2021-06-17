package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;
//2
public class StudentDaoImplements implements studentDao{
	
	private JdbcTemplate jdbctemplate;

	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}


	public int insert(Student student) {
		 //insert query
        String query="insert into student(id, name,city) values(?,?,?)";
        int r = this.jdbctemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}


	public int update(Student student) {
		//update data
		String query="update student set name=?, city=?";
	
		int r = this.jdbctemplate.update(query,student.getName(),student.getCity());
		return r;
	}

	//delete data
	public int delete(int studentdelete) {
		String query="delete from student where id=? ";
		int dl = this.jdbctemplate.update(query,studentdelete);
		return dl;
	}

      // // to get a single data in the form of object
//	public Student getStudent(int studentId) {
//		String query="select * from student where id=? ";
//		RowMapper<Student> rowMapper = new RowMapperImplements();
//		Student student=this.jdbctemplate.queryForObject(query, rowMapper,studentId);
//		return student;
//	}
	
	
	 // // to get a single data in the form of object using Annonimous Class
	public Student getStudent(int studentId) {
		String query="select * from student where id=? ";
		//RowMapper<Student> rowMapper = new RowMapperImplements();
		Student student=this.jdbctemplate.queryForObject(query, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student =new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
			
		},studentId);
		return student;
	}


	public List<Student> getAllStudent() {
		// selecting multiple darta
		String query ="select * from student ";
		List<Student> students = this.jdbctemplate.query(query, new RowMapperImplements());
		return students;
	}
	


	



}
