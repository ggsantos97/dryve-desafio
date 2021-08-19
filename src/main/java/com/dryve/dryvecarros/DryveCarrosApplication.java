package com.dryve.dryvecarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.dryve.dryvecarros"})
@EnableCaching
public class DryveCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DryveCarrosApplication.class, args);
	}

}
