package com.example.Spring_Eval.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Salarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String matricule;

    String CodeBarre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCodeBarre() {
        return CodeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        CodeBarre = codeBarre;
    }

    public Convention getConvention() {
        return convention;
    }

    public void setConvention(Convention convention) {
        this.convention = convention;
    }

    @ManyToOne
    @JoinColumn(name = "Convention_id")
    private Convention convention;
}
