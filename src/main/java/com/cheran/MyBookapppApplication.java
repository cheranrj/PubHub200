package com.cheran;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBookapppApplication {

	private static final Logger LOGGER = Logger.getLogger(MyBookapppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyBookapppApplication.class, args);
		LOGGER.info("Application Started");

	}
}
