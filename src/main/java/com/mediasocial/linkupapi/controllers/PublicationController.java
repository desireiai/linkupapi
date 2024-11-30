/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.controllers;

/**
 *
 * @author NATH-CHRIST
 */
import com.mediasocial.linkupapi.services.dto.PublicationDto;
import com.mediasocial.linkupapi.services.impl.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    private final PublicationServiceImpl publicationsService;

    @Autowired
    public PublicationController(PublicationServiceImpl publicationsService) {
        this.publicationsService = publicationsService;
    }

    @PostMapping
    public ResponseEntity<PublicationDto> creerPublication(@RequestBody PublicationDto publicationDto) {
        PublicationDto nouvellePublication = publicationsService.creerPublication(publicationDto);
        return new ResponseEntity<>(nouvellePublication, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDto> mettreAJourPublication(@PathVariable Integer id, @RequestBody PublicationDto publicationDto) {
        Optional<PublicationDto> publicationMiseAJour = publicationsService.mettreAJourPublication(id, publicationDto);
        return publicationMiseAJour
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPublication(@PathVariable Integer id) {
        publicationsService.supprimerPublication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}