package com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Services;

import static org.junit.Assert.*;
import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Services.PeopleService;
import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models.Person;
import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models.PersonRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleServiceTest {

	@Autowired
    private PersonRepository personRepo;
	
	@Test
	public void testSavePerson() {
		
		try
		{
			Person person = new Person(); 
			person.setId(9999);
			person.setFirstName("John");
			person.setLastName("Doe");
			person.setEmailAddress("jDoe@gmail.com");
			
			//create new PeopleService
			PeopleService personService = new PeopleService();
			//add the people repo to the PeopleService
			personService.setPersonRepository(personRepo);
			//save person
			boolean pass = personService.savePerson(person);
			//if exception is thrown the test fails
			if(pass == false)
			{
				fail("Person failed to save");
			}
			
		}
		catch(Exception ex)
		{
			fail("Exception: "+ ex.toString());
		}
		
		
		
	}

	@Test
	public void testGetEmployeeById() {
		//create new PeopleService
		PeopleService personService = new PeopleService();
		//add the people repo to the PeopleService
		personService.setPersonRepository(personRepo);
		//check the Db if the person exists
		Person foundPerson = personService.getPersonById((long)1001);
		if(foundPerson == null)
		{
			fail("Person could not be retrieved by ID");
		}
	}

	@Test
	public void testGetEmployeeByEmail() {
		//create new PeopleService
				PeopleService personService = new PeopleService();
				//add the people repo to the PeopleService
				personService.setPersonRepository(personRepo);
				//check the Db if the person exists
				List<Person> foundPerson = personService.getPersonByEmail("Perkins109@gmail.com");
				if(foundPerson == null)
				{
					fail("Person could not be retrieved by Email");
				}
	}

}
