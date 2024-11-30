package com.mediasocial.linkupapi.services.dto;

import java.util.Date;

public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String email;
    private String bio;
     private String motDePasse;
    
    private Date dateInscription;
    

    public UtilisateurDto() {
    }

    public UtilisateurDto(String nom, String email, String bio, Date dateInscription) {
        this.nom = nom;
        this.email = email;
        this.bio = bio;
        this.dateInscription = dateInscription;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    
}