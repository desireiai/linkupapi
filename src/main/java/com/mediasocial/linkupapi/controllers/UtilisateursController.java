/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediasocial.linkupapi.controllers;

/**
 *
 * @author NATH-CHRIST
 */
import com.mediasocial.linkupapi.security.LoginRequest;
import com.mediasocial.linkupapi.services.dto.UtilisateurDto;
import com.mediasocial.linkupapi.services.impl.UtilisateursServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateursController {

    private final UtilisateursServiceImpl utilisateursService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public UtilisateursController(UtilisateursServiceImpl utilisateursService) {
        this.utilisateursService = utilisateursService;
    }

    @PostMapping("/inscription")
    public ResponseEntity<UtilisateurDto> inscrireUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurDto.setDateInscription(new Date());
        UtilisateurDto nouveauUtilisateur = utilisateursService.inscrireUtilisateur(utilisateurDto);
        return new ResponseEntity<>(nouveauUtilisateur, HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            // Authentifier l'utilisateur
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println("userdetails" + userDetails.toString());

            
            return ResponseEntity.ok("Utilisateur" + loginRequest.getEmail() + "conncecté avec succès");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants incorrects");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur est survenue lors de la connexion");
        }
    }

    @PostMapping("/deconnexion")
    public ResponseEntity<String> deconnecterUtilisateur(HttpServletRequest request, HttpServletResponse response) {
        // Invalider la session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Effacer le contexte de sécurité
        SecurityContextHolder.clearContext();

        // Supprimer le cookie de session côté client (si vous utilisez des cookies)
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ResponseEntity.ok("Déconnexion réussie");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> obtenirUtilisateur(@PathVariable Integer id) {
        return utilisateursService.obtenirUtilisateur(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> mettreAJourUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDto utilisateurDto) {
        return utilisateursService.mettreAJourUtilisateur(id, utilisateurDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerUtilisateur(@PathVariable Integer id) {
        utilisateursService.supprimerUtilisateur(id);
        return ResponseEntity.ok("Élément avec l'ID " + id + " supprimé avec succès");
    }
}
