package com.personalProject.Crud_hibernate_project;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CrudhibernateApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(CrudhibernateApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
