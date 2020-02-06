package com.projm.rmsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories("com.projM.projMRMSapi.repositories")
@EnableAutoConfiguration
@SpringBootApplication
public class ProjMRmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjMRmsApiApplication.class, args);
	}

}
