package com.ashokit.usermgmt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ashokit.usermgmt.model.CountryModel;
import com.ashokit.usermgmt.model.UserModel;
import com.ashokit.usermgmt.pojo.UserRequestDto;
import com.ashokit.usermgmt.service.UserManagementService;



@RestController
@RequestMapping("/api/registration")
public class UserManagementRestController {

	Logger logger = LoggerFactory.getLogger(UserManagementRestController.class);
	
	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/countries")
	public Map<Integer, String> getCountries(){
		return userManagementService.getAllCountries();
	}
	
	@GetMapping("/states/{countryId}")
	public Map<Integer, String> getStatesById(@PathVariable Integer countryId){
		return userManagementService.getStates(countryId);
	}
	
	@GetMapping("/cities/{stateId}")
	public Map<Integer, String> getCitiesById(@PathVariable Integer stateId){
		return userManagementService.getCities(stateId);
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> registerUser(@RequestBody UserModel userModel){
		boolean isSave = userManagementService.saveUser(userModel);
		if(isSave) {
			return new ResponseEntity<>("Successfully created", HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/emailValidate/{email}")
	public ResponseEntity<?> validateEmail(@PathVariable String email){
		boolean responseStatus = false;
		try {
		responseStatus = userManagementService.isEmailUnique(email);
		return new ResponseEntity<>(responseStatus, HttpStatus.OK);
		}
		catch(Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(responseStatus, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	//change status from LOCKED to UNLOCKED
	@PostMapping("/unlockaccountsubmit")
	public ResponseEntity<String> unlockUserAccount(@RequestBody UserRequestDto userRequsetDto){
		boolean isAccountUnlock = false;
		try {
			isAccountUnlock = userManagementService.unlockUserAccount(userRequsetDto);
			if(isAccountUnlock==true) {
				return new ResponseEntity<>("Account is unlocked, Please proceed with login", HttpStatus.OK);
			}
		}catch(Exception e) {
			System.err.println(e);																																																																																																																																																												
		}
		return new ResponseEntity<>("unable to unlock account because temp password is invalid", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserModel user){
		String responseMessage = null;
		try {
		responseMessage = userManagementService.loginCheck(user.getEmail(), user.getPassword());
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		}catch(Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/forgotpassword/{email}")
	public ResponseEntity<String> forgotPassword(@PathVariable String email){
		String responseMessage = null;
		try {
		responseMessage = userManagementService.updatePassword(email);
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		}catch(Exception e) {
			System.err.println(e);
			return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
