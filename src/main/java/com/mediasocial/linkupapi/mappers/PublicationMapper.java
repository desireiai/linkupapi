package com.mediasocial.linkupapi.mappers;

import com.mediasocial.linkupapi.entities.Publications;
import com.mediasocial.linkupapi.services.dto.PublicationDto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationMapper INSTANCE = Mappers.getMapper(PublicationMapper.class);

    @Mapping(source = "utilisateurId.id", target = "utilisateurId")
    PublicationDto publicationToPublicationDto(Publications publication);

    @Mapping(target = "utilisateurId", ignore = true)
    @Mapping(target = "commentairesList", ignore = true)
    @Mapping(target = "likesList", ignore = true)
    @InheritInverseConfiguration
    Publications publicationDtoToPublication(PublicationDto publicationDto);

    List<PublicationDto> publicationsToPublicationDtos(List<Publications> publications);

    List<Publications> publicationDtosToPublications(List<PublicationDto> publicationDtos);
}