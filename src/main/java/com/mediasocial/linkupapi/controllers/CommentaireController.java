package com.mediasocial.linkupapi.controllers;

import com.mediasocial.linkupapi.services.dto.CommentaireDto;
import com.mediasocial.linkupapi.services.impl.CommentaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    private final CommentaireServiceImpl commentaireService;

    @Autowired
    public CommentaireController(CommentaireServiceImpl commentaireService) {
        this.commentaireService = commentaireService;
    }

    @PostMapping
    public ResponseEntity<CommentaireDto> ajouterCommentaire(@RequestBody CommentaireDto commentaireDto) {
        CommentaireDto nouveauCommentaire = commentaireService.ajouterCommentaire(commentaireDto);
        return new ResponseEntity<>(nouveauCommentaire, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentaireDto> mettreAJourCommentaire(@PathVariable Integer id, @RequestBody CommentaireDto commentaireDto) {
        Optional<CommentaireDto> commentaireMisAJour = commentaireService.mettreAJourCommentaire(id, commentaireDto);
        return commentaireMisAJour
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCommentaire(@PathVariable Integer id) {
        commentaireService.supprimerCommentaire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}