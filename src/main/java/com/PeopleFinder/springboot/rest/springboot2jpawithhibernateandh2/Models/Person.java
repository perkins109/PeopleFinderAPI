package com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.Email;;;

@Entity
//@NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE LOWER(p.emailAddress) = LOWER(?1)")
public class Person {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "firtName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(unique=true, name = "emailAddress" ) //Email addresses should be unique as one email should only be assigned to one person
	@Email
	private String emailAddress;
	
	/**
	 * This entity is used to represent a person, a person has an ID, first name, last name, and email
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 */
	public Person(long id, String firstName, String lastName, String emailAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}
	
	public Person() {
		
	}
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	

}
