package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = "entity")
public class HospitalApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

}