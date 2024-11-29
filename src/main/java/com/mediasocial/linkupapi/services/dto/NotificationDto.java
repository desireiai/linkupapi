/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.services.dto;

import java.time.LocalDateTime;

/**
 *
 * @author NATH-CHRIST
 */
public class NotificationDto {
    private Long id;
    private Long utilisateurId;
    private String type;
    private String contenu;
    private boolean lu;
    private LocalDateTime dateCreation;

    public NotificationDto() {
    }

    public NotificationDto(Long utilisateurId, String type, String contenu, boolean lu, LocalDateTime dateCreation) {
        this.utilisateurId = utilisateurId;
        this.type = type;
        this.contenu = contenu;
        this.lu = lu;
        this.dateCreation = dateCreation;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public boolean isLu() {
        return lu;
    }

    public void setLu(boolean lu) {
        this.lu = lu;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    
}