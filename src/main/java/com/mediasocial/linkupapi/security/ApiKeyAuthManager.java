/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.security;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author NATH-CHRIST
 */

public class ApiKeyAuthManager implements AuthenticationManager {

    private final String validApiKey;

    public ApiKeyAuthManager(String validApiKey) {
        this.validApiKey = validApiKey;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String providedKey = (String) authentication.getPrincipal();
        if (!validApiKey.equals(providedKey)) {
            throw new BadCredentialsException("API Key invalide");
        }
        authentication.setAuthenticated(true);
        return authentication;
    }
}