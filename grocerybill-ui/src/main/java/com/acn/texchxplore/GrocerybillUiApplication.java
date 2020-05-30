package com.acn.texchxplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.acn.texchxplore.config.GroceryBillConfig;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "webservice", configuration = GroceryBillConfig.class)
public class GrocerybillUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrocerybillUiApplication.class, args);
	}

}
