package com.copaco.quoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuotesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotesServiceApplication.class, args);
	}

}
