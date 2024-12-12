package com.example.Spring_Eval.dao;

import com.example.Spring_Eval.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer> {
}
