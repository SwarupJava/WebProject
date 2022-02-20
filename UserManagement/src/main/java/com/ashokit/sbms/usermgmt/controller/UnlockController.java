// 
// Decompiled by Procyon v0.5.36
// 

package com.ashokit.sbms.usermgmt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.sbms.usermgmt.service.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/api/unlock" })
@Api("UnlockController")
public class UnlockController
{
    private UserServiceImpl userService;
    
    public UnlockController(final UserServiceImpl userService) {
        this.userService = userService;
    }
    
    @ApiOperation("To verify temp password")
    @PostMapping({ "/verifyTempPass" })
    public Boolean getTempPasswordVerified(@RequestBody final TempPassVerification temp) {
        final Boolean result = this.userService.isTempPasswordValid(temp.getEmail(), temp.getTempPassword());
        return result;
    }
    
    @ApiOperation("To unlock account")
    @PostMapping({ "/setnewpassword" })
    public Boolean getUnlock(@RequestBody final UnlockRequest unlockRequest) {
        final Boolean result = this.userService.unlockAccount(unlockRequest.getEmail(), unlockRequest.getTempPassword(), unlockRequest.getNewPassword());
        return result;
    }
}
