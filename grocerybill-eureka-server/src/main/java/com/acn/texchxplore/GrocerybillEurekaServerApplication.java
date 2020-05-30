package com.acn.texchxplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GrocerybillEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrocerybillEurekaServerApplication.class, args);
	}

}
