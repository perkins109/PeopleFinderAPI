package com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@EntityScan( basePackages = {"com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2.Models"} )
@ComponentScan(basePackages = {"com.PeopleFinder.springboot.rest.springboot2jpawithhibernateandh2"})
public class SpringBoot2JpaWithHibernateAndH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JpaWithHibernateAndH2Application.class, args);
	}
}
