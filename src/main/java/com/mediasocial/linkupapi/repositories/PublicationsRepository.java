/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.repositories;

import com.mediasocial.linkupapi.entities.Publications;
import com.mediasocial.linkupapi.entities.Utilisateurs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NATH-CHRIST
 */
@Repository
public interface PublicationsRepository extends JpaRepository<Publications, Integer>{
//    List<Publications> findByUtilisateur(Utilisateurs utilisateurId);
}
