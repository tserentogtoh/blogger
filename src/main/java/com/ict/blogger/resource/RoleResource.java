/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.resource;

import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.logic.RoleLogic;
import com.ict.blogger.dto.RoleDTO;
import com.ict.blogger.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tseke
 */
@RestController
public class RoleResource {
    
    @Autowired
    private RoleRepo repo;
    @Autowired
    private RoleLogic logic;
    
    @PostMapping("/roleAdd")
    public ResponseDTO roleAdd(@RequestBody RoleDTO dTO){
        
        return logic.addRole(dTO);
      
    }
}
