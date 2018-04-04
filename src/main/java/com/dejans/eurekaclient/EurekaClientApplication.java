package com.dejans.eurekaclient;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;

import javax.json.JsonReader;
import javax.json.Json;
import javax.json.JsonObject;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {
	static final private String clientName = "eureka-client";

	private static JsonObject jsonFromString(String jsonObjectStr) {

		JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
		JsonObject object = jsonReader.readObject();
		jsonReader.close();

		return object;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String port = new String();
		RestTemplate restTemplate = new RestTemplate();
		long pid = ProcessHandle.current().pid();
		HttpUtils uriClass = new HttpUtils();
		String uri = uriClass.setScheme("http").setHost("localhost").setPort("1111").setPath("/portset/")
				.addParamToQuery("clientName", clientName).addParamToQuery("XZ", "Jugo%$!@#Tugo#$%^&*())\"Sreca")
				.addParamToQuery("pid", pid).getUrl();
		System.out.println("URI " + uri);
		String jsonAnswer = restTemplate.getForObject(uri, String.class);
		JsonObject jobj = jsonFromString(jsonAnswer);
		int portInt = jobj.getInt("port");
		port = Integer.toString(portInt);
		System.out.println("TEXTIC");
		System.out.println(jsonAnswer);

		System.out.println("TEXTIC");

		System.setProperty("server.port", port);
		SpringApplication.run(EurekaClientApplication.class, args);
		System.out.println(jsonAnswer);
	}
}
