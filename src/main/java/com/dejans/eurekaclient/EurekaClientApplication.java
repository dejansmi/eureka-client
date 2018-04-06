package com.dejans.eurekaclient;



import com.dejans.HttpUtils.SetPortOfMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {
	static final private String clientName = "eureka-client";


	public static void main(String[] args) {
		SetPortOfMicroservice.setPort(clientName);
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
