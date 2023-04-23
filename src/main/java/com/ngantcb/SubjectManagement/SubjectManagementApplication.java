package com.ngantcb.SubjectManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ngantcb.SubjectManagement.*")
@EntityScan("com.ngantcb.SubjectManagement.*")
public class SubjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectManagementApplication.class, args);
	}

}
