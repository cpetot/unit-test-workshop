package com.cpetot.workshop.tu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerWebConfiguration.class)
public class WorkshopUnitTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopUnitTestsApplication.class, args);
	}
}
