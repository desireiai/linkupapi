/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.services.impl;

import com.mediasocial.linkupapi.entities.Utilisateurs;
import com.mediasocial.linkupapi.mappers.UtilisateurMapper;
import com.mediasocial.linkupapi.repositories.UtilisateursRepository;
import com.mediasocial.linkupapi.services.UtilisateursService;
import com.mediasocial.linkupapi.services.dto.UtilisateurDto;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author NATH-CHRIST
 */
@Service
public class UtilisateursServiceImpl extends BaseServiceImpl<Utilisateurs, Integer> implements UtilisateursService {

    private final UtilisateursRepository utilisateursRepository;
    private final UtilisateurMapper utilisateursMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateursServiceImpl(UtilisateursRepository utilisateursRepository, 
                                   UtilisateurMapper utilisateursMapper,
                                   PasswordEncoder passwordEncoder) {
        this.utilisateursRepository = utilisateursRepository;
        this.utilisateursMapper = utilisateursMapper;
        this.passwordEncoder = passwordEncoder;
    }

  

    public UtilisateurDto inscrireUtilisateur(UtilisateurDto utilisateurDTO) {
        Utilisateurs utilisateur = utilisateursMapper.utilisateurDtoToUtilisateur(utilisateurDTO);
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
        utilisateur.setDateInscription(new Date());
        Utilisateurs savedUtilisateur = utilisateursRepository.save(utilisateur);
        return utilisateursMapper.utilisateurToUtilisateurDto(savedUtilisateur);
    }

    public UtilisateurDto verifiercredentialsUtilisateur(String email, String motDePasse) {
        Utilisateurs utilisateur = utilisateursRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        
        if (passwordEncoder.matches(motDePasse, utilisateur.getMotDePasse())) {
            return utilisateursMapper.utilisateurToUtilisateurDto(utilisateur);
        } else {
            throw new RuntimeException("Mot de passe incorrect");
        }
    }

    public Optional<UtilisateurDto> obtenirUtilisateur(Integer id) {
        return utilisateursRepository.findById(id).map(utilisateursMapper::utilisateurToUtilisateurDto);
    }

    public Optional<UtilisateurDto> mettreAJourUtilisateur(Integer id, UtilisateurDto utilisateurDTO) {
        return utilisateursRepository.findById(id)
                .map(existingUtilisateur -> {
                    utilisateurDTO.setId(id);
                    Utilisateurs updatedUtilisateur = utilisateursMapper.utilisateurDtoToUtilisateur(utilisateurDTO);
                    // Ne pas écraser le mot de passe existant si un nouveau n'est pas fourni
                    if (utilisateurDTO.getMotDePasse() != null && !utilisateurDTO.getMotDePasse().isEmpty()) {
                        updatedUtilisateur.setDateInscription(new Date());
                        updatedUtilisateur.setMotDePasse(passwordEncoder.encode(utilisateurDTO.getMotDePasse()));
                    } else {
                        updatedUtilisateur.setDateInscription(new Date());
                        updatedUtilisateur.setMotDePasse(existingUtilisateur.getMotDePasse());
                    }
                    updatedUtilisateur = utilisateursRepository.save(updatedUtilisateur);
                    return utilisateursMapper.utilisateurToUtilisateurDto(updatedUtilisateur);
                });
    }

    public void supprimerUtilisateur(Integer id) {
        utilisateursRepository.deleteById(id);
    }
}