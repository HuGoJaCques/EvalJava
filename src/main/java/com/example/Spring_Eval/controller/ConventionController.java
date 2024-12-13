package com.example.Spring_Eval.controller;

import com.example.Spring_Eval.dao.ConventionDao;
import com.example.Spring_Eval.model.Convention;
import com.example.Spring_Eval.model.Entreprise;
import com.example.Spring_Eval.security.IsAdministrateur;
import com.example.Spring_Eval.security.IsEntreprise;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ConventionController {

    @Autowired
    private ConventionDao conventionDao;

    @IsAdministrateur
    @PostMapping("/convention")
    public ResponseEntity<Convention> create(
            @RequestBody @Valid Convention convention) {

        conventionDao.save(convention);

        return new ResponseEntity<>(convention, HttpStatus.CREATED);
    }

    // Mettre à jour une convention existante
    @IsEntreprise
    @PutMapping("/convention/{id}")
    public ResponseEntity<Convention> update(
            @RequestBody @Valid Convention conventionEnvoye, @PathVariable Integer id) {

        conventionEnvoye.setId(id);

        //On vérifie que l'utilisateur existe bien dans la base de donnée
        Optional<Convention> optionalConvention = conventionDao.findById(id);

        //si l'utilisateur n'existe pas
        if(optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        conventionDao.save(conventionEnvoye);

        return new ResponseEntity<>(optionalConvention.get(), HttpStatus.OK);
    }

    @DeleteMapping("/convention/{id}")
    public ResponseEntity<Convention> delete(@PathVariable int id) {
        conventionDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}