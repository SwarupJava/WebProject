package com.ashokit.sbms.usermgmt.service;


import com.ashokit.sbms.usermgmt.entity.City;
import com.ashokit.sbms.usermgmt.entity.State;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.ashokit.sbms.usermgmt.entity.Country;
import java.util.Map;
import java.util.Optional;

import com.ashokit.sbms.usermgmt.entity.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.ashokit.sbms.usermgmt.repository.CityRepository;
import com.ashokit.sbms.usermgmt.repository.StateRepository;
import com.ashokit.sbms.usermgmt.repository.UserRepository;
import com.ashokit.sbms.usermgmt.util.PasswordUtils;
import com.ashokit.sbms.usermgmt.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService
{
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private CountryRepository countryRepository;
    private StateRepository stateRepository;
    private CityRepository cityRepository;
    private UserRepository userRepository;
    private PasswordUtils passwordUtils;
 
    
    public UserServiceImpl(final CountryRepository countryRepository, final StateRepository stateRepository, final CityRepository cityRepository, final UserRepository userRepository, final PasswordUtils passwordUtils) {
        
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
        this.userRepository = userRepository;
        this.passwordUtils = passwordUtils;
    }
    
    @Override
    public Boolean saveUser(User user) {
        logger.debug("**** saveUser() - Execution Started ****");
        user.setStatus("LOCKED");
        final String temp = this.passwordUtils.generateRandomString();
        System.err.println(temp);
        user.setPassword(this.passwordUtils.encryptPassword(temp));
        try {
            //User savedUser = (User)this.userRepository.saveAll((Iterable<S>)user);
            User savedUser = this.userRepository.save(user);
            if (savedUser != null) {
                logger.info("**** saveUser() - User Saved ****");
                return true;
            }
        }
        catch (Exception e) {
           logger.error(String.format("**** saveUser() - Exception Occured : **** %s", e.getMessage()));
        }
        logger.info("**** saveUser() - User Not Saved ****");
        logger.debug("**** saveUser() - Execution Ended ****");
        return false;
    }
    
    
    /**
    @Override
    public Map<Long, String> getCountries() {
        this.logger.debug("**** getCountries() - Execution Started ****");
        final List<Country> countries = (List<Country>)this.countryRepository.findAll();
        final Map<Long, String> countryMap = countries.stream().collect(Collectors.toMap((Function<? super Object, ? extends Long>)Country::getId, (Function<? super Object, ? extends String>)Country::getCountryName));
        this.logger.info("**** getCountries() - Execution Ended ****");
        return countryMap;
    }
    **/
    
    
    @Override
    public Map<Long, String> getStates(Long countryId) {
        logger.debug("**** getStates() - Execution Started ****");
        Optional<State> states = stateRepository.findById(countryId);
        //final Map<Long, String> stateMap = states.stream().collect(Collectors.toMap((Function<? super Object, ? extends Long>)State::getId, (Function<? super Object, ? extends String>)State::getStateName));
        Map<Long, String> map = new HashMap<>();
        
        // put every value list to Map 
       // for (State stu : states) { 
           // map.put(stu.getId(), stu.getStateName()); 
        //} 
  
        // print map 
        System.out.println("Map  : " + states);
        logger.info("**** getStates() - Execution Ended ****");
        return map;
    }
    
    
    /**
    @Override
    public Map<Long, String> getCities(final Long id) {
        this.logger.debug("**** getCities() - Execution Started ****");
        final List<City> cities = (List<City>)this.cityRepository.findByStateId(id);
        final Map<Long, String> citiesMap = cities.stream().collect(Collectors.toMap((Function<? super Object, ? extends Long>)City::getId, (Function<? super Object, ? extends String>)City::getCityName));
        this.logger.info("**** getCities() - Execution Ended ****");
        return citiesMap;
    }
    **/
    
    /**
    @Override
    public Boolean loginCheck(final String email, final String password) {
        this.logger.debug("**** loginCheck() - Execution Started ****");
        final List<User> users = this.userRepository.findByEmail(email);
        if (users.isEmpty()) {
            this.logger.info("**** loginCheck() - User Not Found ****");
            return false;
        }
        final User user = users.get(0);
        if (user.getStatus().equals("LOCKED")) {
            this.logger.info("**** loginCheck() - User Account Locked ****");
            return false;
        }
        this.logger.debug("**** loginCheck() - Execution Ended ****");
        return this.passwordUtils.verifyPassword(password, user.getPassword());
    }
    **/
    /**
    @Override
    public Boolean isTempPasswordValid(final String email, final String tempPassword) {
        this.logger.debug("**** isTempPasswordValid() - Execution Started ****");
        final List<User> users = this.userRepository.findByEmail(email);
        if (users.isEmpty()) {
            this.logger.info("**** isTempPasswordValid() - User Not Found ****");
            return false;
        }
        final User user = users.get(0);
        if (user.getStatus().equals("UNLOCKED")) {
            this.logger.info("**** isTempPasswordValid() - User already Unlocked ****");
            return false;
        }
        this.logger.info("**** isTempPasswordValid() - Execution Ended ****");
        return this.passwordUtils.verifyPassword(tempPassword, user.getPassword());
    }
    **/
    /**
    @Override
    public Boolean unlockAccount(final String email, final String tempPassword, final String newPassword) {
        this.logger.debug("**** unlockAccount() - Execution Started ****");
        final List<User> users = this.userRepository.findByEmail(email);
        if (users.isEmpty()) {
            this.logger.info("**** unlockAccount() - User Account Not Found ****");
            this.logger.debug("**** unlockAccount() - Execution Ended ****");
            return false;
        }
        final User user = users.get(0);
        if (!this.passwordUtils.verifyPassword(tempPassword, user.getPassword())) {
            this.logger.info("**** unlockAccount() - Password did not match ****");
            return false;
        }
        if (user.getStatus().equals("LOCKED")) {
            user.setPassword(this.passwordUtils.encryptPassword(newPassword));
            user.setStatus("UNLOCKED");
            this.userRepository.save((Object)user);
            this.logger.info("**** unlockAccount() - User Account Unlocked ****");
            return true;
        }
        this.logger.info("**** unlockAccount() - User Account Already Unlocked ****");
        this.logger.debug("**** unlockAccount() - Execution Ended ****");
        return false;
    }
    **/
    
    
    @Override
    public Boolean isEmailRegistered(final String email) {
        this.logger.debug("**** isEmailRegistered() - Execution Started ****");
        final List<User> users = this.userRepository.findByEmail(email);
        if (users.isEmpty()) {
            this.logger.info("**** isEmailRegistered() - Email Not Found ****");
            this.logger.debug("**** isEmailRegistered() - Execution Ended ****");
            return false;
        }
        this.logger.info("**** isEmailRegistered() - Email Found ****");
        return true;
    }
    
    @Override
    public Boolean sendPasswordToUserEmail(final String email) {
        return null;
    }
	

	@Override
	public Map<Long, String> getCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Map<Long, String> getCities(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean unlockAccount(String email, String tempPassword, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean loginCheck(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isTempPasswordValid(String email, String tempPassword) {
		// TODO Auto-generated method stub
		return null;
	}
    /**
	@Override
	public Boolean isEmailRegistered(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	**/
}
