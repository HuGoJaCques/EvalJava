package com.example.Spring_Eval.dao;

import com.example.Spring_Eval.model.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarieDao extends JpaRepository<Salarie, Integer> {
}
