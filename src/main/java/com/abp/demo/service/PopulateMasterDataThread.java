package com.abp.demo.service;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.abp.demo.model.SampleData;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Scope("prototype")
public class PopulateMasterDataThread implements Callable<String> {

	private static final String SERVER_URI = "http://13.126.233.155:8226/search/elastic_search_sampledata/";
	private static final Logger LOGGER = LoggerFactory.getLogger(PopulateMasterDataThread.class);

	private String request;

	public PopulateMasterDataThread(String request) {
		this.request = request;
	}

	@Override
	public String call() throws Exception {
		LOGGER.debug("Thread started [" + request + "]");
		return doWork();
	}

	public String doWork() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		String rand1 = getAlphaNumericString(3);
		String rand2 = getAlphaNumericString(4);
		String rand3 = getAlphaNumericString(5);
		String rand4 = getAlphaNumericString(6);
		String fixed = "xxxxxxxxxxx";

		ResponseEntity<String> rest;
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			SampleData data = new SampleData();
			data.setRand1(rand1);
			data.setRand2(rand2);
			data.setRand3(rand3);
			data.setRand4(rand4);
			data.setFixed(fixed);

			rest = restTemplate.exchange(SERVER_URI, HttpMethod.POST,
					new HttpEntity<String>(objectMapper.writeValueAsString(data), headers), String.class);
			LOGGER.debug(rest.getBody());
		} catch (RestClientException e) {
			LOGGER.error("An unexpected interrupt exception occurred!", e);
		} catch (JsonGenerationException e) {
			LOGGER.error("An unexpected interrupt exception occurred!", e);
		} catch (JsonMappingException e) {
			LOGGER.error("An unexpected interrupt exception occurred!", e);
		} catch (IOException e) {
			LOGGER.error("An unexpected interrupt exception occurred!", e);
		}
		return "Request [" + request + "] " + createUUID();
	}

	private String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	private String createUUID() {
		UUID id = UUID.randomUUID();
		return id.toString();
	}
}
