/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.dto.UserDTO;
import com.ict.blogger.entities.User;
import com.ict.blogger.repo.UserRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tseke
 */



@Service
@Transactional
public class UserCheck {
    
    @Autowired
    UserRepo repo;
    @Transactional
    public boolean UserCheck(UserDTO dTO){
        List<User> userList = new ArrayList<>();
        
         userList =  repo.findAll();
       
        for(User user: userList){
            if(user.getEmail().equals(dTO.getEmail())){
                return false;
            }
        }
        return true;
    }
}
