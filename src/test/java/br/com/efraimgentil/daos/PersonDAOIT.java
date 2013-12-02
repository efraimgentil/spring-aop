package br.com.efraimgentil.daos;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.efraimgentil.models.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "/spring/application-config.xml" })
public class PersonDAOIT {
	
	
	@Autowired
	PersonDAO personDAO;
	
	@Test
	public void testIfAOPIsWorking() throws Exception{
		
		File file = new File("persons.txt");
		Person[] persons = new Person[10];
		
		assert personDAO.getClass().equals( PersonDAO.class ) == false;
		System.out.println( personDAO.getClass().equals( PersonDAO.class ) == false );
		
		personDAO.persistAll(persons, file);
		
	}
	
//	public static void main(String[] args) throws Exception {
//		
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("spring/application-config.xml");
//		
//		File file = new File("persons.txt");
//		Person[] persons = new Person[10];
//		
//		PersonDAO dao = context.getBean("personDAO", PersonDAO.class);
//
//		assert dao.getClass().equals( PersonDAO.class ) == false;
//		System.out.println( dao.getClass().equals( PersonDAO.class ) == false );
//		
//		dao.persistAll(persons, file);
//		
//	}
	
}
