package com.mediasocial.linkupapi.mappers;

import com.mediasocial.linkupapi.services.dto.UtilisateurDto;
import com.mediasocial.linkupapi.entities.Utilisateurs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    // Mapper de l'entité Utilisateur vers le DTO UtilisateurDto
    UtilisateurDto utilisateurToUtilisateurDto(Utilisateurs utilisateur);

    // Mapper du DTO UtilisateurDto vers l'entité Utilisateur
    @Mapping(target = "dateInscription", ignore = true) // Ignorer si vous gérez cela différemment
    @Mapping(target = "motDePasse", ignore = true)
    @Mapping(target = "abonnementsList", ignore = true)

    @Mapping(target = "abonnementsList1", ignore = true)
    @Mapping(target = "commentairesList", ignore = true)
    @Mapping(target = "notificationsList", ignore = true)
    @Mapping(target = "likesList", ignore = true)
    @Mapping(target = "publicationsList", ignore = true)

    Utilisateurs utilisateurDtoToUtilisateur(UtilisateurDto utilisateurDto);

    // Mapper des listes
    List<UtilisateurDto> utilisateursToUtilisateurDtos(List<Utilisateurs> utilisateurs);

    List<Utilisateurs> utilisateurDtosToUtilisateurs(List<UtilisateurDto> utilisateurDtos);

}