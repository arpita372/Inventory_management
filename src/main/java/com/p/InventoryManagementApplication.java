package com.p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InventoryManagementApplication {

	public static void main(String[] args) {
		//System.out.println(SpringBootApplication.class.getProtectionDomain().getCodeSource().getLocation());
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

}
