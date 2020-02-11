package com.projm.rmsapi;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



//@ComponentScan({"com.projm.rmsapi.repositories","com.projm.rmsapi.controllers", "com.projm.rmsapi.services"})
@SpringBootApplication
//@ComponentScan({"com.projm.rmsapi.services"})
@EnableJpaRepositories({"com.projm.rmsapi.repositories", "com.app"})
public class ProjMRmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjMRmsApiApplication.class, args);
	}

}
