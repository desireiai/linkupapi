/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mediasocial.linkupapi.repositories;

import com.mediasocial.linkupapi.entities.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NATH-CHRIST
 */
@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Integer>{
    
}
