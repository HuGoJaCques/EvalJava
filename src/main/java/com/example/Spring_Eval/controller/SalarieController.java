package com.example.Spring_Eval.controller;

import com.example.Spring_Eval.dao.ConventionDao;
import com.example.Spring_Eval.dao.SalarieDao;
import com.example.Spring_Eval.model.Convention;
import com.example.Spring_Eval.model.Salarie;
import com.example.Spring_Eval.security.IsAdministrateur;
import com.example.Spring_Eval.security.IsEntreprise;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class SalarieController {

    @Autowired
    private SalarieDao salarieDao;
    @Autowired
    private ConventionDao conventionDao;

    @IsEntreprise
    @PostMapping("/salarie")
    public ResponseEntity<Salarie> create(
            @RequestBody @Valid Salarie salarie) {

        Optional<Convention> optionalConvention = conventionDao.findById(salarie.getConvention().getId());
        if (optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Convention convention = optionalConvention.get();

        if(convention.getSalaries().size() >= convention.getSalarie_maximum()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }else {
            salarieDao.save(salarie);

            return new ResponseEntity<>(salarie, HttpStatus.CREATED);
        }

    }

    // Mettre à jour une convention existante
    @IsEntreprise
    @PutMapping("/salarie/{id}")
    public ResponseEntity<Salarie> update(
            @RequestBody @Valid Salarie salarieEnvoye, @PathVariable Integer id) {

        salarieEnvoye.setId(id);

        //On vérifie que l'utilisateur existe bien dans la base de donnée
        Optional<Salarie> optionalSalarie = salarieDao.findById(id);

        //si l'utilisateur n'existe pas
        if(optionalSalarie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        salarieDao.save(salarieEnvoye);

        return new ResponseEntity<>(optionalSalarie.get(), HttpStatus.OK);
    }

    @IsEntreprise
    @DeleteMapping("/salarie/{id}")
    public ResponseEntity<Salarie> delete(@PathVariable int id) {
        salarieDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
