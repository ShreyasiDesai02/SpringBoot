package com.Shreyasi.SpringDataJpa.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.Shreyasi.SpringDataJpa.Model.Guardian;
import com.Shreyasi.SpringDataJpa.Model.Student;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("shreyasi.desai@gmail.com")
				.firstName("Shreyasi")
				.lastName("Desai")
//				.guardianName("Shivaji")
//				.guardianEmail("shivajidesai@gmail.com")
//				.guardianMobile("9988776655")
				.build();
		
		studentRepo.save(student);
	}
	
	 @Test
	    public void saveStudentWithGuardian() {

	        Guardian guardian = Guardian.builder()
	                .email("shivajidesai@gmail.com")
	                .name("Shivaji")
	                .mobile("9988776655")
	                .build();

	        Student student = Student.builder()
	                .firstName("Shreyasi")
	                .emailId("shreyasi.desai@gmail.com")
	                .lastName("Desai")
	                .guardian(guardian)
	                .build();

	        studentRepo.save(student);

	    }
	
	 @Test
	    public void printAllStudent() {
	        List<Student> studentList =
	        		studentRepo.findAll();

	        System.out.println("studentList = " + studentList);
	    }
	 
	 @Test
	    public void printStudentByFirstName() {
	        
	        List<Student> students =
	                studentRepo.findByFirstName("Shreyasi");

	        System.out.println("students = " + students);
	    }
	 
	 @Test
	    public void printStudentByFirstNameContaining() {

	        List<Student> students =
	                studentRepo.findByFirstNameContaining("sh");

	        System.out.println("students = " + students);
	    }
	 
	 @Test
	    public void printStudentBasedOnGuardianName(){
	        List<Student> students =
	                studentRepo.findByGuardianName("Shivaji");
	        System.out.println("students = " + students);
	    }
	 
	 @Test
	    public void printgetStudentByEmailAddress() {
	        Student student =
	                studentRepo.getStudentByEmailAddress(
	                        "shreyasi.desai@gmail.com"
	                );

	        System.out.println("student = " + student);
	    }
	 
	 @Test
	    public void printgetStudentFirstNameByEmailAddress() {
	        String firstName =
	                studentRepo.getStudentFirstNameByEmailAddress(
	                        "shreyasi.desai@gmail.com"
	                );
	        System.out.println("firstName = " + firstName);
	    }
	    
	    @Test
	    public void printgetStudentByEmailAddressNative(){
	        Student student =
	                studentRepo.getStudentByEmailAddressNative(
	                        "shreyasi.desai@gmail.com"
	                );

	        System.out.println("student = " + student);
	    }
	    
	    @Test
	    public void printgetStudentByEmailAddressNativeNamedParam() {
	        Student student =
	                studentRepo.getStudentByEmailAddressNativeNamedParam(
	                        "shivam@gmail.com"
	                );

	        System.out.println("student = " + student);
	    }

	    @Test
	    public void updateStudentNameByEmailIdTest() {
	        studentRepo.updateStudentNameByEmailId(
	                "sshreyasi desai",
	                "shreyasi@gmail.com");
	    }


}
