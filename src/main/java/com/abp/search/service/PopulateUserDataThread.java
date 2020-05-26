package com.abp.search.service;

import java.util.UUID;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PopulateUserDataThread implements Callable<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopulateUserDataThread.class);

	@Autowired
	private UserSearchService userSearchService;  
	
	private String request;

	public PopulateUserDataThread(String request) {
		this.request = request;
	}

	@Override
	public String call() throws Exception {
		LOGGER.debug("Thread started [" + request + "]");
		return doWork();
	}

	public String doWork() {

//		saveUserDataFromDB(51343L);
		userSearchService.saveUserDataFromDB(Long.parseLong(request), false);
		return "Request [" + request + "] " + createUUID();
	}

	private String createUUID() {
		UUID id = UUID.randomUUID();
		return id.toString();
	}
}
