package com.ashokit.usermgmt.service;

import java.text.SimpleDateFormat;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.ashokit.usermgmt.model.CityModel;
import com.ashokit.usermgmt.model.CountryModel;
import com.ashokit.usermgmt.model.StateModel;
import com.ashokit.usermgmt.model.UserModel;
import com.ashokit.usermgmt.pojo.UserRequestDto;
import com.ashokit.usermgmt.repositories.CityRepository;
import com.ashokit.usermgmt.repositories.CountryRepository;
import com.ashokit.usermgmt.repositories.StateRepository;
import com.ashokit.usermgmt.repositories.UserRepository;
import com.ashokit.usermgmt.util.AES256;
import com.ashokit.usermgmt.util.AppUtil;
import com.ashokit.usermgmt.util.EmailUtil;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Override
	public Map<Integer, String> getAllCountries() {
		List<CountryModel> countriesList = countryRepository.findAll();
		Map<Integer, String> countriesMap = new HashMap<Integer, String>();
		countriesList.forEach(country->{
			countriesMap.put(country.getCountryId(), country.getCountryName());
		});
		return countriesMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateModel> statelist = stateRepository.findByCountryId(countryId);
		Map<Integer, String> statesMap = new HashMap<Integer, String>();
		statelist.forEach(state->{
			statesMap.put(state.getStateId(), state.getStateName());
		});
		return statesMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
	      List<CityModel> citiList = cityRepository.findByStateId(stateId);
	      Map<Integer, String> cityMap = new HashMap<Integer, String>();
	      citiList.forEach(city->{
		        cityMap.put(city.getCityId(), city.getCityName());
	      });
	      return cityMap;
	}

	@Override
	public boolean saveUser(UserModel userModel) {
		boolean isEmailExist = false;
		boolean isUserCreated = false;
		//check email is exist in db or not
		//if it is present in db this is duplicate
		isEmailExist = isEmailUnique(userModel.getEmail());
		if(isEmailExist) {
		    String password = AppUtil.generateRandomString(8);
		    String encryptedPassword = AES256.encrypt(password);
		    userModel.setPassword(encryptedPassword);
		    userModel.setStatus("LOCKED");
		    Date date = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		    String createDate = formatter.format(date);  
		    System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+createDate); 
		    userModel.setDateCreated(createDate);
		    Date date1 = new Date();  
		    String updateDate = formatter.format(date1);
		    System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+updateDate);
		    userModel.setDateUpdated(updateDate);
		    
		    UserModel savedUser = userRepository.save(userModel);
		    
		    if(savedUser != null) {
		    	isUserCreated = true;
		    	String subject = "UNLOCK ACCOUNT";
		    	String text = "<html><body> Hi, " + userModel.getFirstName() + " " + userModel.getLastName() + ": "
						+ "<br><b>Welcome to Ashok IT.,</b> Your registeration is almost complete."
						+ "<br>Please unlock your account using below details." + " <br><br>Your Temporary Password : " + encryptedPassword
						+ "<br><a href='http://localhost:9193/unlockaccount'>Click here to unlock account</a></body></html>";
		         emailUtil.send(userModel.getEmail(), text, subject);
		    }else {
		    	isUserCreated = false;
		    }
		    
		    
		}
		
		
		
		return isUserCreated;
		
		
		
		/*
		 * userModel.setStatus("LOCKED"); String temp =
		 * passwordUtil.generateRandomString(); System.out.println(temp);
		 * System.out.println(passwordUtil.encryptPassword(temp));
		 * userModel.setPassword(passwordUtil.encryptPassword(temp)); UserModel
		 * savedUser = userRepository.save(userModel); if(savedUser.getUserId()!=null) {
		 * return true; } return false;
		 */
	}

	@Override
	public boolean isEmailUnique(String email) {
		boolean isUnique = false;
		UserModel user = userRepository.findUserByEmail(email);
		if(user == null) {
			isUnique = true;
		}else {
			isUnique =  false;
		}
		return isUnique;
	}

	@Override
	@Transactional
	public boolean unlockUserAccount(UserRequestDto userRequsetDto) {
		boolean isTempPasswordValid=false;
		int activeUserCount = 0;
		boolean isAccountActivated = false;
		boolean passwordMatch = false;
		//validate temp password which is received in email by validating email and password in db
		isTempPasswordValid = isTempPwdValid(userRequsetDto.getEmail(), userRequsetDto.getTempPassword());
		//check new password matches with confirm password or not
		if(userRequsetDto.getNewPassword().equals(userRequsetDto.getConfirmPassword())) {
			passwordMatch = true;
		}
		   
		if(isTempPasswordValid && passwordMatch) {
			   userRequsetDto.setUserAccountStatus("UNLOCKED");
			   activeUserCount = userRepository.updateAccountStatus(userRequsetDto.getUserAccountStatus(), userRequsetDto.getEmail());
		   }
		   if(activeUserCount == 1) {
				isAccountActivated = true;
			}else {
				isAccountActivated = false;
			}
		
		return isAccountActivated;
	}

	@Override
	public boolean isTempPwdValid(String email, String password) {
		boolean isTemporaryPwdValid = false;
		UserModel user = userRepository.findUserByEmailAndPassword(email, password);
		if(user != null) {
			isTemporaryPwdValid = true;
		}else {
			isTemporaryPwdValid = false;
		}
		return isTemporaryPwdValid;
	}

	@Override
	public String loginCheck(String email, String password) {
		String respMsg = null;
		UserModel user = userRepository.findUserByEmailAndPassword(email, password);
		if(user != null) {
			if(user.getStatus().equals("UNLOCKED")) {
				System.out.println("Login successfully ...........");
				respMsg = "Login successfully ...........";
				
			}else {
				System.out.println("Your status is unlocked");
				respMsg = "Your status is unlocked";
			}
		}else{
			System.out.println("Invalid credentials ...........");
			respMsg = "Invalid credentials ...........";
		}
		return respMsg;
	}

	@Override
	@Transactional
	public String updatePassword(String email) {
		int isPasswordUpdate = 0;
		String respMessage = null;
		UserModel user = userRepository.findUserByEmail(email);
		if(user != null) {
			//generate password
			String password = AppUtil.generateRandomString(8);
		    String encryptedPassword = AES256.encrypt(password);
		    isPasswordUpdate = userRepository.updatePassword(encryptedPassword, email);
		    if(isPasswordUpdate>0) {
		    	respMessage = "Password updated successfully .........";
		    	String subject = "Update Password";
		    	String text = "<html><body> Hi, Your requested new Password : " + encryptedPassword + "</body></html>";
		         emailUtil.send(email, text, subject);
		         System.out.println("email sent successfully");
		    }else {
		    	respMessage = "Failed to update password ..........";
		    }
		}
		return respMessage;
	}
	
	

}
