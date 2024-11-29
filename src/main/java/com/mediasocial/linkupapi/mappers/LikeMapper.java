/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.mappers;

/**
 *
 * @author NATH-CHRIST
 */

import com.mediasocial.linkupapi.services.dto.LikeDto;
import com.mediasocial.linkupapi.entities.Likes; // Assurez-vous d'importer votre entité Like
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    // Mapper de l'entité Like vers le DTO LikeDto
    @Mapping(source = "publicationId.id", target = "publicationId") // Mapper l'ID de la publication
    @Mapping(source = "utilisateurId.id", target = "utilisateurId") // Mapper l'ID de l'utilisateur
    LikeDto likeToLikeDto(Likes like);

    // Mapper du DTO LikeDto vers l'entité Like
    @Mapping(target = "publicationId", ignore = true) // Ignorer la publication lors de la conversion inverse
    @Mapping(target = "utilisateurId", ignore = true) // Ignorer l'utilisateur lors de la conversion inverse
    Likes likeDtoToLike(LikeDto likeDto);

    // Mapper des listes
    List<LikeDto> likesToLikeDtos(List<Likes> likes);

    List<Likes> likeDtosToLikes(List<LikeDto> likeDtos);
}
