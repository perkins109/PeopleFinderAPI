package com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<Person, Long> {

    //List<Person> findById(UUID id);
	@Query("SELECT u FROM Person u WHERE u.emailAddress = :emailAddress")
	public List<Person> findByEmail(@Param("emailAddress") String emailAddress);
}
