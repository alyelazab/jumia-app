package com.JumiaServices.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.JumiaServices.task.Entity"})
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
