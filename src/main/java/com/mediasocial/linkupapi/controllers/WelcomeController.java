/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NATH-CHRIST
 */
@RestController
public class WelcomeController {

    @GetMapping({"", "/", "/welcome"})
    public String welcome() {
     
        return "<html>" +
                "<head>" +
                "<title>Bienvenue</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }" +
                "h1 { color: #4CAF50; }" +
                "p { font-size: 18px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<h1>Bienvenue sur notre API ! ils s'agit du projet Link Up cours 4DESA groupe OLIVIER-Murielle-Martiale MENG1</h1>" +
                "<p>Nous sommes ravis de vous accueillir.</p>" +
                "</body>" +
                "</html>";
    }
     
}
