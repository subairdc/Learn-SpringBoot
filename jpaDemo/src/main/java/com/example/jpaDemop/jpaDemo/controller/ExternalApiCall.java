package com.example.jpaDemop.jpaDemo.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController(value = "ExternalApiCall")
@CrossOrigin("*")
@RequestMapping("/api")
public class ExternalApiCall {

	@GetMapping("/callApi")
	public String callApi(String api) {
		RestTemplate restTemplate = new RestTemplate();
		Object object = restTemplate.getForObject(api, String.class);
		return object.toString();
	}

	@GetMapping("/callApiWithBody")
	public String callApiWithBody(String api) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("companyId", "comatecfleet");
			map.put("branchId", "comatecfleet");
			map.put("userId", "comatecfleet-ca");
			map.put("dcName", "vehicleDisplay");
			String body = new ObjectMapper().writeValueAsString(map);
			HttpEntity<String> entity = new HttpEntity<>(body);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> obj = restTemplate.postForEntity(api, entity, String.class);

//			JSONParser parser = new JSONParser();
//			JSONArray jsonObject = (JSONArray) parser.parse(obj.getBody());

			JSONArray jsonObject = new ObjectMapper().readValue(obj.getBody(), JSONArray.class);

			return jsonObject.toString();
		} catch (Exception e) {

			System.out.println(e);
		}
		return null;
	}

	@GetMapping("/callApiWithSpringSecure")
	public String callApiWithSpringSecure(String api) {

		String unameAndPass = "rzp_test_pCovO5uBVTngQU:RlS3lokJHxdYR8aMq0DFFAUh";
		String base64Creds = Base64.getEncoder().encodeToString(unameAndPass.getBytes());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		HttpEntity<String> request = new HttpEntity<>(headers);

		ResponseEntity<String> response = new RestTemplate().exchange(api, HttpMethod.GET, request, String.class);

		String json = response.getBody();
		return json;

	}

	
	private String className;

	@Value("${some.key:ClassName is ExternalApiCall}")
	public void setClassName(String className) {
		System.out.println("It is ExternalApiCall Setter Method");
		this.className = className;
	}

	public void display() {
		System.out.println("It is ExternalApiCall utill Method");
	}

	@PostConstruct
	public void init1() {
		System.out.println("It is ExternalApiCall Init 1 Method");
	}
	@PostConstruct
	public void init3() {
		System.out.println("It is ExternalApiCall Init 3 Method");
	}
	@PostConstruct
	public void init2() {
		System.out.println("It is ExternalApiCall Init 2 Method");
	}
	

	@PreDestroy
	public void destroy() {
		System.out.println("It is ExternalApiCall Destroy Method");
	}

}
