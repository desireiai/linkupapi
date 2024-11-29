/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mediasocial.linkupapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author NATH-CHRIST
 */
@SpringBootApplication(exclude = {PropertyPlaceholderAutoConfiguration.class})
@EntityScan("com.mediasocial.linkupapi.entities")
@ComponentScan(basePackages = {"com.mediasocial.linkupapi.controllers", "com.mediasocial.linkupapi.services", "com.mediasocial.linkupapi.mappers", "com.mediasocial.linkupapi.security"})
@EnableJpaRepositories
@EnableCaching
public class Linkupapi {

    public static void main(String[] args) {
        SpringApplication.run(Linkupapi.class, args);
    }
}
