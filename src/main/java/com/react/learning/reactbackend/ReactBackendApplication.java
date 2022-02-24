package com.react.learning.reactbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class ReactBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactBackendApplication.class, args);
	}

}
