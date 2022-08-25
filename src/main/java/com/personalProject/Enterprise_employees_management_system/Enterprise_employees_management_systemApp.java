package com.personalProject.Enterprise_employees_management_system;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Enterprise_employees_management_systemApp {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Enterprise_employees_management_systemApp.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
