/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author tseke
 */
@Service
public class IdGenerator {
    
    public Long userId(){
        Long id;
        Date dNow = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddhhmmssMs");
        String dateTime = df.format(dNow);
        id = Long.parseLong(dateTime);
        return id;  
    }
    
}
