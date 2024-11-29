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
public class CommentaireDto implements Serializable{
    private Integer id;
    private Integer publicationId;
    private Integer utilisateurId;
    private String contenu;
    private LocalDateTime dateCreation;

    public CommentaireDto() {
    }

    public CommentaireDto(Integer publicationId, Integer utilisateurId, String contenu, LocalDateTime dateCreation) {
        this.publicationId = publicationId;
        this.utilisateurId = utilisateurId;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Integer publicationId) {
        this.publicationId = publicationId;
    }

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
    
    


    public void setId(int id) {
        this.id = id;
    }

    

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    
}