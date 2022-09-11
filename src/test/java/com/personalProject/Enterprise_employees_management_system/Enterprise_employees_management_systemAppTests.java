package com.personalProject.Enterprise_employees_management_system;

import com.personalProject.Enterprise_employees_management_system.controller.EmployeeRestController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Enterprise_employees_management_systemAppTests {

	private static final Logger logger
			= LoggerFactory.getLogger(Enterprise_employees_management_systemAppTests.class);

	@Autowired
	private EmployeeRestController employeeRestController;
	@Test
	void contextLoads() throws Exception {

		logger.info("Example log from {}", Enterprise_employees_management_systemAppTests.class.getSimpleName());
		Assertions.assertThat(employeeRestController).isNotNull();
	}


}
