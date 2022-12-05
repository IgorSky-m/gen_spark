package edu.genspark.week_4_assignment_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class Week4Assignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(Week4Assignment1Application.class, args);
	}

}
