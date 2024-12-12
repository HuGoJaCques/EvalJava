package com.example.Spring_Eval.controller;

import com.example.Spring_Eval.model.Utilisateur;
import com.example.Spring_Eval.dao.UtilisateurDao;
import com.example.Spring_Eval.security.IsAdministrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;

    // Lire tous les utilisateurs
    @GetMapping("/utilisateur")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDao.findAll();
    }


}
