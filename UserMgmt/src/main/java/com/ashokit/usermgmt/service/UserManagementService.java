package com.ashokit.usermgmt.service;

import java.util.Map;

import com.ashokit.usermgmt.model.UserModel;
import com.ashokit.usermgmt.pojo.UserRequestDto;


public interface UserManagementService {

	Map<Integer, String> getAllCountries();

	Map<Integer, String> getStates(Integer countryId);

	Map<Integer, String> getCities(Integer stateId);

	boolean saveUser(UserModel userModel);

	boolean isEmailUnique(String email);

	boolean unlockUserAccount(UserRequestDto userRequsetDto);
	
	public boolean isTempPwdValid(String email, String password);

	String loginCheck(String email, String password);

	String updatePassword(String email);

}
