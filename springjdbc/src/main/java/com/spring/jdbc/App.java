package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.studentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //spring jdbc ->jdbcTemplate
       // ApplicationContext context=new ClassPathXmlApplicationContext(" com/spring/jdbc/jdbcconfig.xml");
//       ///1 JdbcTemplate template = context.getBean("jdbcTemlate",JdbcTemplate.class);
//        
//        //insert query
//        String query="insert into student(id, name,city) values(?,?,?)";
//        //Fire query
//       int result= template.update(query,101,"Aditya Maurya","Noida");
//       System.out.println( "number of record inserted"+ result );
        
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        studentDao bean = context.getBean("studentDao",studentDao.class);
        //++++++++++++++++++++++++++++++++++  insert the data ++++++++++++++++++++++++++++++++++++++++++++++//
      
     
       
       Student st=new Student();
       st.setId(106);
       st.setName("Chandan ");
       st.setCity("Bhatni");
       int insert = bean.insert(st);
       System.out.println( "number of record inserted "+ insert );
        
       //++++++++++++++++++++++++++++++++++  update the data ++++++++++++++++++++++++++++++++++++++++++++++//
//       
//       Student st=new Student();
//       st.setId(101);
//       st.setName("Aditya ");
//       st.setCity("Greater Noida");
//       int upda = bean.update(st);
//       System.out.println( "number of record update "+ upda );
       
       //++++++++++++++++++++++++++++++++++  delete the data++++++++++++++++++++++++++++++++++++++++++++++//
//     int result= bean.delete(102);
//     System.out.println( "number of record deleted "+ result );
       
       
       //++++++++++++++++++++++++++++++++++  get  the data in object form ++++++++++++++++++++++++++++++++++++++++++++++//
       
//       Student student = bean.getStudent(103);
//       System.out.println( student );
      List<Student> student= bean.getAllStudent();
      for(Student s:student) {
    	  System.out.println(s);  
      }
     
    }
       
}
