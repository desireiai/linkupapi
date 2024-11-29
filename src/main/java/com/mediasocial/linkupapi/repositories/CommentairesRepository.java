/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.repositories;

import com.mediasocial.linkupapi.entities.Commentaires;
import com.mediasocial.linkupapi.entities.Publications;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NATH-CHRIST
 */
@Repository
public interface CommentairesRepository extends JpaRepository<Commentaires, Integer>{
//            List<Commentaires> findByPublication(Publications publicationId);
}
