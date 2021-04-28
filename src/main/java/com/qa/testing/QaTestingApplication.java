package com.qa.testing;

import com.qa.testing.model.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Database.class)
public class QaTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaTestingApplication.class, args);
	}

}
