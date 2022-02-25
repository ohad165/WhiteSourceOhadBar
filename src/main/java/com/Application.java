package com;

import com.data.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com")
@EntityScan(basePackages = "com")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		logger.info("********** Ready and running ***********");
	}

	@Bean
	public CommandLineRunner run(EmployeeRepository repository) {
		return (args) -> {
			insertFourEmployees(repository);
			System.out.println(repository.findAll());
		};
	}

	private void insertFourEmployees(EmployeeRepository repository) {
		repository.save(new Employee("Einav Shechter", "1234"));
		repository.save(new Employee("Ruslan Gogerman", "12345"));
		repository.save(new Employee("Ohad Bar", "123456"));
	}
}
