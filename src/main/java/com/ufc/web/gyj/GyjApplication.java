package com.ufc.web.gyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GyjApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GyjApplication.class, args);
		
	}
}
