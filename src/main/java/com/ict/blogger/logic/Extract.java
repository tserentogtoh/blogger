/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import java.security.Principal;
import java.util.Map;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 *
 * @author tseke
 */
public class Extract {
    
    
    public static Long extractUserId(Principal principal) {

        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;

            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            Object decodedDetails = details.getDecodedDetails();

            if (decodedDetails instanceof Map) {
                Map<String, Object> detailsMap = (Map<String, Object>) decodedDetails;
                if (detailsMap.containsKey("user_id")) {
                    return ((Number) detailsMap.get("user_id")).longValue();
                }
            }
            boolean clientOnly = authentication.isClientOnly();
            System.out.println("clientOnly = " + clientOnly);
        }
        return null;
    }
    
        public static Long extractRoleId(Principal principal) {

        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;

            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            Object decodedDetails = details.getDecodedDetails();

            if (decodedDetails instanceof Map) {
                Map<String, Object> detailsMap = (Map<String, Object>) decodedDetails;
                if (detailsMap.containsKey("role_id")) {
                    return ((Number) detailsMap.get("role_id")).longValue();
                }
            }
            boolean clientOnly = authentication.isClientOnly();
            System.out.println("clientOnly = " + clientOnly);
        }
        return null;
    }
}
