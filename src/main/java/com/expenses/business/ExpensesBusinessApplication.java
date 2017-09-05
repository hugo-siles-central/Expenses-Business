package com.expenses.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.expenses.business.service"})
@EntityScan("com.expenses.persistence.entities")
@EnableJpaRepositories(basePackages = "com.expenses.persistence.repository")
public class ExpensesBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesBusinessApplication.class, args);
	}
}
