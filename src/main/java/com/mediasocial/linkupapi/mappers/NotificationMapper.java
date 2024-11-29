/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.mappers;

/**
 *
 * @author NATH-CHRIST
 */

import com.mediasocial.linkupapi.services.dto.NotificationDto;
import com.mediasocial.linkupapi.entities.Notifications; // Assurez-vous d'importer votre entité Notification
import org.mapstruct.Mapping;

import java.util.List;

import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    // Mapper de l'entité Notification vers le DTO NotificationDto
    @Mapping(source = "utilisateurId.id", target = "utilisateurId") // Mapper l'ID de l'utilisateur
    NotificationDto notificationToNotificationDto(Notifications notification);

    // Mapper du DTO NotificationDto vers l'entité Notification
    @Mapping(target = "utilisateurId", ignore = true) // Ignorer l'utilisateur lors de la conversion inverse
    Notifications notificationDtoToNotification(NotificationDto notificationDto);

    // Mapper des listes
    List<NotificationDto> notificationsToNotificationDtos(List<Notifications> notifications);

    List<Notifications> notificationDtosToNotifications(List<NotificationDto> notificationDtos);
}
