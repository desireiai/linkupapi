/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
/**
 *
 * @author NATH-CHRIST
 */
@Entity
@Table(name = "commentaires")
@NamedQueries({
    @NamedQuery(name = "Commentaires.findAll", query = "SELECT c FROM Commentaires c")})
public class Commentaires implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "publication_id", referencedColumnName = "id")
    @ManyToOne
    private Publications publicationId;
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs utilisateurId;

    public Commentaires() {
    }

    public Commentaires(Integer id) {
        this.id = id;
    }

    public Commentaires(Integer id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Publications getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Publications publicationId) {
        this.publicationId = publicationId;
    }

    public Utilisateurs getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Utilisateurs utilisateurId) {
        this.utilisateurId = utilisateurId;
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
        if (!(object instanceof Commentaires)) {
            return false;
        }
        Commentaires other = (Commentaires) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mediasocial.linkupapi.entities.Commentaires[ id=" + id + " ]";
    }
    
}
