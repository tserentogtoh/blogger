/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author tseke
 */
public class GetIP {
    
    public static String getRequestIP(HttpServletRequest request){
       
        String ip = request.getHeader("X-Forwarded-For");
        if(ip == null || "".equals(ip)) {
            return request.getRemoteAddr();
        }
        return ip;
    }
}
