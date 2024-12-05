/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.services.impl;

import com.mediasocial.linkupapi.entities.Publications;
import com.mediasocial.linkupapi.entities.Utilisateurs;
import com.mediasocial.linkupapi.mappers.PublicationMapper;
import com.mediasocial.linkupapi.repositories.PublicationsRepository;
import com.mediasocial.linkupapi.repositories.UtilisateursRepository;
import com.mediasocial.linkupapi.services.PublicationsService;
import com.mediasocial.linkupapi.services.dto.PublicationDto;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NATH-CHRIST
 */

@Service
public class PublicationServiceImpl extends BaseServiceImpl<Publications, Integer> implements PublicationsService {

    private final PublicationsRepository publicationRepository;
    private final PublicationMapper publicationMapper;
    private final UtilisateursRepository utilisateursRepository;

    @Autowired
    public PublicationServiceImpl(PublicationsRepository publicationRepository, 
                                  PublicationMapper publicationMapper,
                                  UtilisateursRepository utilisateursRepository) {
        this.publicationRepository = publicationRepository;
        this.publicationMapper = publicationMapper;
        this.utilisateursRepository = utilisateursRepository;
    }


    public PublicationDto creerPublication(PublicationDto publicationDTO) {
        Optional<Utilisateurs> utilisateur = utilisateursRepository.findById(publicationDTO.getUtilisateurId());
        Publications publication = publicationMapper.publicationDtoToPublication(publicationDTO);
        publication.setUtilisateurId(utilisateur.get());
        publication.setDateCreation(new Date());
        Publications savedPublication = publicationRepository.save(publication);
        return publicationMapper.publicationToPublicationDto(savedPublication);
    }

//    public List<PublicationDto> obtenirPublicationsParUtilisateur(Integer utilisateurId) {
//        Utilisateurs utilisateur = utilisateursRepository.findById(utilisateurId)
//            .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
//        List<Publications> publications = publicationRepository.findByUtilisateur(utilisateur);
//        return publicationMapper.publicationsToPublicationDtos(publications);
//    }

    public Optional<PublicationDto> mettreAJourPublication(Integer id, PublicationDto publicationDTO) {
        return publicationRepository.findById(id)
                .map(existingPublication -> {
                    publicationDTO.setId(id);
                    Publications updatedPublication = publicationMapper.publicationDtoToPublication(publicationDTO);
                    updatedPublication = publicationRepository.save(updatedPublication);
                    return publicationMapper.publicationToPublicationDto(updatedPublication);
                });
    }

    public void supprimerPublication(Integer id) {
        publicationRepository.deleteById(id);
    }
}