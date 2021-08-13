package com.dryve.dryvecarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dryve.dryvecarros"})
public class DryveCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DryveCarrosApplication.class, args);
	}

}
