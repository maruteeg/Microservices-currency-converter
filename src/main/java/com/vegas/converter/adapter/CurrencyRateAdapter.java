package com.vegas.converter.adapter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyRateAdapter {

	public double getCurrencyRate(String sourceCountryCode, String targetCountryCode) {

		String forexServiceURL = "http://localhost:8080/forex/rate/{sourceCountryCode}/{targetCountryCode}";
		String username = "user";
		String password = "user";

		/*
		 * Authentication using httpEntity String credentials =
		 * Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
		 * HttpHeaders headers = new HttpHeaders(); headers.add("Authorization",
		 * "Basic " + credentials); HttpEntity<String> httpEntity = new
		 * HttpEntity<String>(headers);
		 */
		RestTemplate restTemplate = new RestTemplate();

		// Authentication using intercepter
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
		Map<String, String> inputParams = new HashMap<>();
		inputParams.put("sourceCountryCode", sourceCountryCode);
		inputParams.put("targetCountryCode", targetCountryCode);

		/*
		 * Authentication using httpEntity ResponseEntity<String> responseEntity =
		 * restTemplate.exchange(forexServiceURL, HttpMethod.GET, String.class,
		 * inputParams);
		 */

		// Authentication using intercepter
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(forexServiceURL, String.class, inputParams);

		if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			throw new RuntimeException("Not able to establish connection with client");
		}
		return Double.valueOf(responseEntity.getBody());
	}
}
