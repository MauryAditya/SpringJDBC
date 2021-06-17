package com.spring.jdbc;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImplements;
import com.spring.jdbc.dao.studentDao;

@Configuration

public class JdbcConfig {

	@Bean("ds")
		public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;	

	}
	@Bean("jdbctemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	
	@Bean(name= { "studentDao" })
	public studentDao getStudentDao() {
		StudentDaoImplements studentDao = new StudentDaoImplements();
		studentDao.setJdbctemplate(getTemplate());
		return studentDao;
		
	}
}
