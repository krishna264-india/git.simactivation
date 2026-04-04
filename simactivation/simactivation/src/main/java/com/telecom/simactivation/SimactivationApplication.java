package com.telecom.simactivation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SimactivationApplication {

	public static void main(String[] args) {

		SpringApplication.run(SimactivationApplication.class, args);
	}

}
