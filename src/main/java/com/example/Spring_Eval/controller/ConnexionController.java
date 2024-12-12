package com.example.Spring_Eval.controller;

import com.example.Spring_Eval.dao.UtilisateurDao;
import com.example.Spring_Eval.model.Utilisateur;
import com.example.Spring_Eval.security.AppUserDetails;
import com.example.Spring_Eval.security.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ConnexionController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private AuthenticationProvider authenticationProvider;

//    @PostMapping("/inscription")
//    public ResponseEntity<Map<String, Object>> inscription(@RequestBody Utilisateur utilisateur) {
//        utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
//        if (utilisateur.getEntreprise() != null) {
//            utilisateur.setRole("ENTREPRISE");
//        } else {
//            utilisateur.setRole("ADMINISTRATEUR");
//        }
//        utilisateurDao.save(utilisateur);
//
//        return ResponseEntity.ok(Map.of("message", "Enregistrement effectué"));
//    }

    @PostMapping("/connexion")
    public ResponseEntity<String> connexion(@Valid @RequestBody Utilisateur utilisateur) {
        try {
            AppUserDetails appUserDetails = (AppUserDetails) authenticationProvider
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    utilisateur.getEmail(),
                                    utilisateur.getPassword()))
                    .getPrincipal();

            return ResponseEntity.ok(jwtUtils.generateToken(appUserDetails.getUsername()));

        } catch (AuthenticationException ex) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/test-jwt")
    public String testJwt() {
        return jwtUtils.generateToken("a@a.com");
    }
}
