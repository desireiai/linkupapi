package com.mediasocial.linkupapi.services.impl;

import com.mediasocial.linkupapi.entities.Commentaires;
import com.mediasocial.linkupapi.entities.Publications;
import com.mediasocial.linkupapi.mappers.CommentaireMapper;
import com.mediasocial.linkupapi.repositories.BaseRepository;
import com.mediasocial.linkupapi.repositories.CommentairesRepository;
import com.mediasocial.linkupapi.repositories.PublicationsRepository;
import com.mediasocial.linkupapi.services.CommentairesService;
import com.mediasocial.linkupapi.services.dto.CommentaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireServiceImpl extends BaseServiceImpl<Commentaires, Integer> implements CommentairesService {

    private final CommentairesRepository commentairesRepository;
    private final PublicationsRepository publicationsRepository;
    private final CommentaireMapper commentaireMapper;

    @Autowired
    public CommentaireServiceImpl(CommentairesRepository commentairesRepository,
                                  PublicationsRepository publicationsRepository,
                                  CommentaireMapper commentaireMapper) {
        this.commentairesRepository = commentairesRepository;
        this.publicationsRepository = publicationsRepository;
        this.commentaireMapper = commentaireMapper;
    }


    public CommentaireDto ajouterCommentaire(CommentaireDto commentaireDTO) {
        Commentaires commentaire = commentaireMapper.commentaireDtoToCommentaire(commentaireDTO);
        Publications publication = publicationsRepository.findById(commentaireDTO.getPublicationId())
                .orElseThrow(() -> new RuntimeException("Publication non trouvée"));
        commentaire.setPublicationId(publication);
        Commentaires savedCommentaire = commentairesRepository.save(commentaire);
        return commentaireMapper.commentaireToCommentaireDto(savedCommentaire);
    }

//    public List<CommentaireDto> obtenirCommentairesParPublication(int publicationId) {
//        Publications publication = publicationsRepository.findById(publicationId)
//                .orElseThrow(() -> new RuntimeException("Publication non trouvée"));
//        List<Commentaires> commentaires = commentairesRepository.findByPublication(publication);
//        return commentaireMapper.commentairesToCommentaireDtos(commentaires);
//    }

    public Optional<CommentaireDto> mettreAJourCommentaire(int id, CommentaireDto commentaireDTO) {
        return commentairesRepository.findById(id)
                .map(existingCommentaire -> {
                    commentaireDTO.setId(id);
                    Commentaires updatedCommentaire = commentaireMapper.commentaireDtoToCommentaire(commentaireDTO);
                    updatedCommentaire = commentairesRepository.save(updatedCommentaire);
                    return commentaireMapper.commentaireToCommentaireDto(updatedCommentaire);
                });
    }

    public void supprimerCommentaire(int id) {
        commentairesRepository.deleteById(id);
    }
}