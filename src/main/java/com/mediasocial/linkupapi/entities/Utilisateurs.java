/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 *
 * @author NATH-CHRIST
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Utilisateurs.findAll", query = "SELECT u FROM Utilisateurs u")})
public class Utilisateurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Lob
    @Column(name = "bio")
    private String bio;
    @Column(name = "date_inscription")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;
    @OneToMany(mappedBy = "abonneId")
    private List<Abonnements> abonnementsList;
    @OneToMany(mappedBy = "abonnementId")
    private List<Abonnements> abonnementsList1;
    @OneToMany(mappedBy = "utilisateurId")
    private List<Commentaires> commentairesList;
    @OneToMany(mappedBy = "utilisateurId")
    private List<Notifications> notificationsList;
    @OneToMany(mappedBy = "utilisateurId")
    private List<Likes> likesList;
    @OneToMany(mappedBy = "utilisateurId")
    private List<Publications> publicationsList;

    public Utilisateurs() {
    }

    public Utilisateurs(Integer id) {
        this.id = id;
    }

    public Utilisateurs(Integer id, String nom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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

    public List<Abonnements> getAbonnementsList() {
        return abonnementsList;
    }

    public void setAbonnementsList(List<Abonnements> abonnementsList) {
        this.abonnementsList = abonnementsList;
    }

    public List<Abonnements> getAbonnementsList1() {
        return abonnementsList1;
    }

    public void setAbonnementsList1(List<Abonnements> abonnementsList1) {
        this.abonnementsList1 = abonnementsList1;
    }

    public List<Commentaires> getCommentairesList() {
        return commentairesList;
    }

    public void setCommentairesList(List<Commentaires> commentairesList) {
        this.commentairesList = commentairesList;
    }

    public List<Notifications> getNotificationsList() {
        return notificationsList;
    }

    public void setNotificationsList(List<Notifications> notificationsList) {
        this.notificationsList = notificationsList;
    }

    public List<Likes> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<Likes> likesList) {
        this.likesList = likesList;
    }

    public List<Publications> getPublicationsList() {
        return publicationsList;
    }

    public void setPublicationsList(List<Publications> publicationsList) {
        this.publicationsList = publicationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mediasocial.linkupapi.entities.Utilisateurs[ id=" + id + " ]";
    }
    
}
