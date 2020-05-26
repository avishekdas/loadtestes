package com.abp.search.service;

import java.util.List;

import com.abp.search.dto.PPUserInputDTO;
import com.abp.search.dto.UserInputDTO;
import com.abp.search.es.model.AbstractPPUserDAO;
import com.abp.search.es.model.AbstractUserDAO;

public interface UserSearchService {
	
	public void saveUserDataFromDB(Long userId, boolean checkIfExists);
	
	public boolean updateUserData(UserInputDTO userData);
	
	public boolean updatePPUserData(PPUserInputDTO ppUserData);
	
	public List<AbstractUserDAO> searchUserData(UserInputDTO userData);
	
	public List<AbstractPPUserDAO> searchPPUserData(PPUserInputDTO ppUserData);

}
