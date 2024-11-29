/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.repositories;

import com.mediasocial.linkupapi.entities.Utilisateurs;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NATH-CHRIST
 */
@Repository
public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer>{
     Optional<Utilisateurs> findByEmail(String email);
}
