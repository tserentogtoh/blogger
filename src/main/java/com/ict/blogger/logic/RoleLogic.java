/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.entities.Role;
import com.ict.blogger.dto.RoleDTO;
import com.ict.blogger.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tseke
 */
@Service
public class RoleLogic {
    
    @Autowired
    private RoleRepo repo;
    
    public ResponseDTO addRole(RoleDTO dTO){
        
        try{
            Role role = new Role();
            role.setRoleId(dTO.getRoleId());
            role.setrName(dTO.getrName());
            repo.save(role);
            return ResponseDTO.getInstance(true);
        }catch(Exception e){
            return ResponseDTO.getInstance(false, e.getMessage());
        } 
    }
    
}
