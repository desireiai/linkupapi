package com.mediasocial.linkupapi.services.impl;

import com.mediasocial.linkupapi.entities.Utilisateurs;
import com.mediasocial.linkupapi.repositories.UtilisateursRepository;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NATH-CHRIST
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UtilisateursRepository userRepository;

 @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateurs user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email));
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getMotDePasse() , getAuthorities(user));
    

}

    private Collection<? extends GrantedAuthority> getAuthorities(Utilisateurs user) {
        
        // Logique pour récupérer les rôles/autorités de l'utilisateur
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
