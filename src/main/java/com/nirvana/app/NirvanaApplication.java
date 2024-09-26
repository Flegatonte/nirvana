package com.nirvana.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
public class NirvanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NirvanaApplication.class, args);
		System.out.println("up and running!");
	}

}
