package com.example.Spring_Eval.dao;

import com.example.Spring_Eval.model.Convention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConventionDao extends JpaRepository<Convention, Integer> {
}
