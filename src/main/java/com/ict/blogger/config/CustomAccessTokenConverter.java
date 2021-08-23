/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

/**
 *
 * @author esuu
 */
@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication authentication
                = super.extractAuthentication(claims);

        Map<String, Object> details = new HashMap<>(1);
        details.put("user_id", claims.get("user_id"));
        details.put("role_id", claims.get("role_id"));

        authentication.setDetails(details);
        return authentication;
    }
}
