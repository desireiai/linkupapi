/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.repositories.impl;

import com.mediasocial.linkupapi.repositories.BaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public abstract class BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {
  
}