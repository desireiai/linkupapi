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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import javax.persistence.Table;
/**
 *
 * @author NATH-CHRIST
 */
@Entity
@Table(name = "abonnements")
@NamedQueries({
    @NamedQuery(name = "Abonnements.findAll", query = "SELECT a FROM Abonnements a")})
public class Abonnements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_abonnement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAbonnement;
    @JoinColumn(name = "abonne_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs abonneId;
    @JoinColumn(name = "abonnement_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs abonnementId;

    public Abonnements() {
    }

    public Abonnements(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAbonnement() {
        return dateAbonnement;
    }

    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }

    public Utilisateurs getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(Utilisateurs abonneId) {
        this.abonneId = abonneId;
    }

    public Utilisateurs getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(Utilisateurs abonnementId) {
        this.abonnementId = abonnementId;
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
        if (!(object instanceof Abonnements)) {
            return false;
        }
        Abonnements other = (Abonnements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mediasocial.linkupapi.entities.Abonnements[ id=" + id + " ]";
    }
    
}
