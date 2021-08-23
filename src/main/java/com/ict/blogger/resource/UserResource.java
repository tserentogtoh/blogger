/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.resource;

import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.logic.UserLogic;
import com.ict.blogger.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tseke
 */
@RestController
@EnableTransactionManagement
@Api(description = "User", tags = "User")
public class UserResource {
    
    @Autowired
    private UserLogic logic;

    @PostMapping("/register")
    @ApiOperation("hereglegch burtgeh")
    public ResponseDTO addUser(@RequestBody UserDTO dTO) {
        
        return logic.userAdd(dTO);
    }
   
}
