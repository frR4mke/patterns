package com.example.jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JasyptApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(JasyptApplication.class, args);

		ServiceTest serviceTest = context.getBean(ServiceTest.class);

		var test =Emumms.CONDITION_ELSE.apply();

		serviceTest.crypt("test");

	}

}
