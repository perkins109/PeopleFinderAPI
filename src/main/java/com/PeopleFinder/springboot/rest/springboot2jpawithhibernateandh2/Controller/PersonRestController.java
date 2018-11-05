package com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models.Person;
import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Services.PeopleService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PersonRestController {
	
	@Autowired
	private PeopleService  personService;
	
	public void setPeopleService(PeopleService personService) {
		this.personService = personService;
	}
	
	/**
	 * POST: Rest endpoint to add a new person to the database
	 * @param person
	 */
	@PostMapping("/PersonFinderAPI/people")
	public void savePerson(@RequestBody Person person){
		personService.savePerson(person);
	}
	
	/**
	 * GET: Rest endpoint to find a database entry in the table Person by Id
	 * @param personId
	 * @return
	 */
	@GetMapping("/PersonFinderAPI/people/Id/{personId}")
	public Person getPerson(@PathVariable(name="personId")Long personId) {
		return personService.getPersonById(personId);
	}
	
	/**
	 * GET: Rest endpoint to find a database entry in the table Person by email address
	 * @param email
	 * @return
	 */
	@GetMapping("/PersonFinderAPI/people/email/{email}")
	public List<Person> getPerson(@PathVariable(name="email")String email) {
		return personService.getPersonByEmail(email);
	}
}
