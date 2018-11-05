package com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Services;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models.Person;
import com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models.PersonRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PersonRepository personRepo;
	
	public void setPersonRepository(PersonRepository personrepo) {
		this.personRepo = personrepo; 
			 }
	/**
	 * Adds a new person to the database
	 * @param person
	 */
	public boolean savePerson(Person person) {
		
		try {
			this.personRepo.save(person);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println("Could not save person. Excpetion: " + ex.toString()); 
		}
		return false;
	}
	/**
	 * Retrieves a person by ID
	 * @param id
	 * @return
	 */
	public Person getPersonById(Long id) {
		
		try {
			Optional<Person> foundPerson = personRepo.findById(id);
		    return foundPerson.get();
		}
		catch(Exception ex)
		{
			System.out.println("Could not get person by ID. Excpetion: " + ex.toString()); 
		}
		return null;
	}
	/**
	 * Retrieves a list of people by email
	 * @param email
	 * @return
	 */
	public List<Person> getPersonByEmail(String email) {
		
		try {
			List<Person> people = personRepo.findByEmail(email);
		    return people;
		}
		catch(Exception ex)
		{
			System.out.println("Could not get person by ID. Excpetion: " + ex.toString()); 
		}
		return null;
	}
}
