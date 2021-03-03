package com.jumia.app.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.jumia.app.server.Entity"})
public class JumiaApplicationServer {

	public static void main(String[] args) {
		SpringApplication.run(JumiaApplicationServer.class, args);
	}

}
