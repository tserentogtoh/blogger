/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.resource;

import com.ict.blogger.dto.ChangeStateDTO;
import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.logic.AdminLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tseke
 */

@RestController
@Api(description = "Admin", tags = "Admin")
public class AdminResourse {
    
    @Autowired
    AdminLogic logic;
    
    @PutMapping("/update/state/{id}")
    @ApiOperation("UPdate status")
    public ResponseDTO changeState(@PathVariable Long id, @RequestBody ChangeStateDTO dTO){
        
        return logic.changeState(id, dTO);   
        
    }
}
