package com.subairdc.springboot.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.subairdc.springboot.database.entity.Person;
import com.subairdc.springboot.database.jdbc.PersonJdbcDao;
import com.subairdc.springboot.database.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		logger.info("All users -> {}", repository.findAll());
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
//		logger.info("Deleting 10002 -> No of Rows Deleted - {}", 
//				repository.deleteById(10002));
		
		logger.info("Inserting 10004 -> {}", 
				repository.insert(new Person("Aasim", "London", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.update(new Person(10003, "Mahir", "Paris", new Date())));
		
	}

}
