package com.microproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MicroProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroProjectApplication.class, args);
	}

}
