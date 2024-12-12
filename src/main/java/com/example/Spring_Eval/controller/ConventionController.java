package com.example.Spring_Eval.controller;

import com.example.Spring_Eval.dao.ConventionDao;
import com.example.Spring_Eval.model.Convention;
import com.example.Spring_Eval.model.Entreprise;
import com.example.Spring_Eval.security.IsAdministrateur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
