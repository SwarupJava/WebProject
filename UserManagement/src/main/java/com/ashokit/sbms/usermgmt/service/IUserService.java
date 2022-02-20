package com.ashokit.sbms.usermgmt.service;

import java.util.Map;

import com.ashokit.sbms.usermgmt.entity.User;

public interface IUserService
{
    Boolean saveUser(User user);
    
    Map<Long, String> getCountries();
    
    Map<Long, String> getStates(final Long id);
    
    Map<Long, String> getCities(final Long id);
    
    Boolean loginCheck(final String email, final String password);
    
    Boolean isTempPasswordValid(final String email, final String tempPassword);
    
    Boolean unlockAccount(final String email, final String tempPassword, final String newPassword);
    
    Boolean isEmailRegistered(final String email);
    
    Boolean sendPasswordToUserEmail(final String email);
}
