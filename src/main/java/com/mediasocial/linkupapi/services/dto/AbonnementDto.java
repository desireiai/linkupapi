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
public class AbonnementDto implements Serializable{
    private Long id;
    private Long abonneId;
    private Long abonnementId;
    private LocalDateTime dateAbonnement;

    public AbonnementDto() {
    }

    public AbonnementDto(Long abonneId, Long abonnementId, LocalDateTime dateAbonnement) {
        this.abonneId = abonneId;
        this.abonnementId = abonnementId;
        this.dateAbonnement = dateAbonnement;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(Long abonneId) {
        this.abonneId = abonneId;
    }

    public Long getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(Long abonnementId) {
        this.abonnementId = abonnementId;
    }

    public LocalDateTime getDateAbonnement() {
        return dateAbonnement;
    }

    public void setDateAbonnement(LocalDateTime dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }
    
    
}