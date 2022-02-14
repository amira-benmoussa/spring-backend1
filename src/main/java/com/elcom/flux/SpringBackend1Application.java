package com.elcom.flux;


import com.elcom.flux.entities.Responsable;
import com.elcom.flux.services.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class SpringBackend1Application {

	

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBackend1Application.class, args);
	}



}
