package com.example.Spring_Eval.dao;

import com.example.Spring_Eval.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Integer> {
}
