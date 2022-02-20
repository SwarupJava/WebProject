package com.ashokit.sbms.usermgmt.controller;


import com.ashokit.sbms.usermgmt.entity.User;
import com.ashokit.sbms.usermgmt.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/api/registration" })
@Api("UserRestController")
public class UserRegistrationRestController
{
    private UserServiceImpl userService;
    
    UserRegistrationRestController(final UserServiceImpl userService) {
        this.userService = userService;
    }
    /**
    @ApiOperation("To get countries")
    @GetMapping({ "/countries" })
    public ResponseEntity<Map<Long, String>> getCountries() {
        final Map<Long, String> map = (Map<Long, String>)this.userService.getCountries();
        return (ResponseEntity<Map<Long, String>>)ResponseEntity.ok((Object)map);
    }
    **/
    
    @PostMapping
	public ResponseEntity<String> saveUser(@RequestBody User user){
		try {
		boolean isSaved = userService.saveUser(user);
		if(isSaved) {
			return new ResponseEntity<>("addedd suvccessfully", HttpStatus.CREATED);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
	}
    
    
    
    @ApiOperation("To get states based on country id")
    @GetMapping({ "/states/{countryId}" })
    public ResponseEntity<Map<Long, String>> getStates(@PathVariable Long countryId) {
        Map<Long, String> map = userService.getStates(countryId);
        //return (ResponseEntity<Map<Long, String>>)ResponseEntity.ok((Object)map);
        
        return new ResponseEntity<Map<Long, String>>(map, HttpStatus.OK);
    }
    
    
    
    
    
    /**
    @ApiOperation("To get cities based on state id")
    @GetMapping({ "/cities/{stateId}" })
    public ResponseEntity<Map<Long, String>> getCities(@PathVariable final Long stateId) {
        final Map<Long, String> map = (Map<Long, String>)this.userService.getCities(stateId);
        return (ResponseEntity<Map<Long, String>>)ResponseEntity.ok((Object)map);
    }
    
    @ApiOperation("To register user")
    @PostMapping({ "/registeruser" })
    public ResponseEntity<String> registerUser(@RequestBody final User user) {
        final Boolean result = this.userService.saveUser(user);
        return (ResponseEntity<String>)(result ? ResponseEntity.status(201).body((Object)"Please check your email to unlock account") : ResponseEntity.status(500).body((Object)"OOPS!! Some error occured"));
    }
    **/
    @ApiOperation("To check if email is registerd")
    @GetMapping({ "isEmailRegistered/{email}" })
    public ResponseEntity<Boolean> isEmailValid(@PathVariable final String email) {
        final Boolean isRegistered = this.userService.isEmailRegistered(email);
        //return (ResponseEntity<Boolean>)ResponseEntity.ok((Object)isRegistered);
        return null;
    }
    
    
}
