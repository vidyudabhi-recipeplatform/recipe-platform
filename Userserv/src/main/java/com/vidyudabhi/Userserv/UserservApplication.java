package com.vidyudabhi.Userserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserservApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserservApplication.class, args);
	}

}
