/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author NATH-CHRIST
 */
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Bienvenue sur notre API !";
    }
}
