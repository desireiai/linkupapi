/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.services.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NATH-CHRIST
 */
public class PublicationDto implements Serializable{
    private Integer id;
    private Long utilisateurId;
    private String contenu;
    private String mediaUrl;
    private Date dateCreation;

    public PublicationDto() {
    }

    public PublicationDto(Long utilisateurId, String contenu, String mediaUrl, Date dateCreation) {
        this.utilisateurId = utilisateurId;
        this.contenu = contenu;
        this.mediaUrl = mediaUrl;
        this.dateCreation = dateCreation;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    
    
}