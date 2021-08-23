/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.dto.UserDTO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tseke
 */
@Service
@Transactional
public class Regex {
    @Transactional
    public boolean RegexEmail(UserDTO dTO){
        
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";
        
        Pattern p = Pattern.compile(regex);
        
        Matcher m = p.matcher(dTO.getEmail());
        
        if (m.matches()) {
                System.out.printf("%s matches%n", dTO.getEmail());
                return true;
            } else {
                System.out.printf("%s does not match%n", dTO.getEmail());
                return false;
            }
    }
    @Transactional
    public boolean RegexPass(UserDTO dTO){
        
        String pattern = "^.*(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(dTO.getPass());
        if (m.matches()){
            System.out.println("Password: " + dTO.getPass() + " is valid");
            return true;
        }else{
            System.out.println("Password: " + dTO.getPass()+ " is NOT valid");
            return false;
        }
    }  
    @Transactional
    public boolean RegexPhoneNo(UserDTO dTO){
        
        String match = dTO.getPhoneNo();
        
        if (match.matches("\\d{8}")){
            System.out.println("PhoneNo: " + dTO.getPhoneNo()+ " is valid");
            return true;
        }else{
            System.out.println("PhoneNo: " + dTO.getPhoneNo()+ " is NOT valid");
            return false;
        }
    }
}
