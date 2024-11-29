package com.mediasocial.linkupapi.mappers;

import com.mediasocial.linkupapi.services.dto.CommentaireDto;
import com.mediasocial.linkupapi.entities.Commentaires;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentaireMapper {

    CommentaireMapper INSTANCE = Mappers.getMapper(CommentaireMapper.class);

    @Mapping(source = "publicationId.id", target = "publicationId")
    @Mapping(source = "utilisateurId.id", target = "utilisateurId")
    CommentaireDto commentaireToCommentaireDto(Commentaires commentaire);

    @Mapping(target = "publicationId", ignore = true)
    @Mapping(target = "utilisateurId", ignore = true)
    Commentaires commentaireDtoToCommentaire(CommentaireDto commentaireDto);

    List<CommentaireDto> commentairesToCommentaireDtos(List<Commentaires> commentaires);

    List<Commentaires> commentaireDtosToCommentaires(List<CommentaireDto> commentaireDtos);
}