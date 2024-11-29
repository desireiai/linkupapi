/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.mappers;

/**
 *
 * @author NATH-CHRIST
 */


import com.mediasocial.linkupapi.services.dto.AbonnementDto;
import com.mediasocial.linkupapi.entities.Abonnements; // Assurez-vous d'importer votre entité Abonnement
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AbonnementMapper {

    AbonnementMapper INSTANCE = Mappers.getMapper(AbonnementMapper.class);

    // Mapper de l'entité Abonnement vers le DTO AbonnementDto
    @Mapping(source = "abonneId.id", target = "abonneId") // Mapper l'ID de l'abonné
    @Mapping(source = "abonnementId.id", target = "abonnementId") // Mapper l'ID de l'abonnement
    AbonnementDto abonnementToAbonnementDto(Abonnements abonnement);

    // Mapper du DTO AbonnementDto vers l'entité Abonnement
    @Mapping(target = "abonneId", ignore = true) // Ignorer l'abonné lors de la conversion inverse
    @Mapping(target = "abonnementId", ignore = true) // Ignorer l'abonnement lors de la conversion inverse
    Abonnements abonnementDtoToAbonnement(AbonnementDto abonnementDto);

    // Mapper des listes
    List<AbonnementDto> abonnementsToAbonnementDtos(List<Abonnements> abonnements);

    List<Abonnements> abonnementDtosToAbonnements(List<AbonnementDto> abonnementDtos);
}