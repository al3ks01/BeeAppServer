package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example.demo")
public class BeeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeeappApplication.class, args);
	}

}
