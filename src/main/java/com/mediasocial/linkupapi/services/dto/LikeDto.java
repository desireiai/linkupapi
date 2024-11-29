/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.services.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author NATH-CHRIST
 */
public class LikeDto implements Serializable{
    private Long id;
    private Long publicationId;
    private Long utilisateurId;
    private LocalDateTime dateCreation;

    public LikeDto() {
    }

    public LikeDto(Long publicationId, Long utilisateurId, LocalDateTime dateCreation) {
        this.publicationId = publicationId;
        this.utilisateurId = utilisateurId;
        this.dateCreation = dateCreation;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    
}