package com.dejans.eurekaclient;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ThreadLocalRandom;

import java.net.URLEncoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {
		RestTemplate restTemplate = new RestTemplate();
		HttpUtils uriClass = new HttpUtils();
		String uri = uriClass.setScheme("http").setHost("localhost").setPort("1111").setPath("/portset/")
				.addParamToQuery("clientName", "eureka-client").addParamToQuery("XZ", "Jugo%$!@#Tugo#$%^&*())\"Sreca").getUrl();
		System.out.println("URI " + uri);
		String quote = restTemplate.getForObject(uri, String.class);
		System.out.println("TEXTIC");
		System.out.println(quote);

		System.out.println(quote);
		System.out.println("TEXTIC");
		String port = "4444";

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = ThreadLocalRandom.current().nextInt(3000, 10000);
		port = Integer.toString(randomNum);

		System.setProperty("server.port", port);
		SpringApplication.run(EurekaClientApplication.class, args);
		System.out.println(quote);
	}
}
