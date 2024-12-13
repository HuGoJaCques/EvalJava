package com.example.Spring_Eval.controller;

import com.example.Spring_Eval.dao.EntrepriseDao;
import com.example.Spring_Eval.model.Entreprise;
import com.example.Spring_Eval.model.Utilisateur;
import com.example.Spring_Eval.security.IsAdministrateur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EntrepriseController {

    @Autowired
    private EntrepriseDao entrepriseDao;


    @GetMapping("/entreprise")
    public List<Entreprise> getAll() {
        return entrepriseDao.findAll();
    }

    // Créer une nouvelle entreprise


    @IsAdministrateur
    @PostMapping("/entreprise")
    public ResponseEntity<Entreprise> create(
            @RequestBody @Valid Entreprise entreprise) {

        entrepriseDao.save(entreprise);

        return new ResponseEntity<>(entreprise, HttpStatus.CREATED);
    }
}
