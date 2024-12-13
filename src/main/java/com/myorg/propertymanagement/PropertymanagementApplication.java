package com.myorg.propertymanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PropertymanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertymanagementApplication.class, args);
	}

}
