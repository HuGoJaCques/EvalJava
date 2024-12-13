package com.example.Spring_Eval.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Convention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nom;

    @Min(value = 0, message = "La subvention doit être supérieure à 0")
    Float subvention;

    @NotNull
    @Min(value = 1, message = "Le nombre de salarié maximum ne peut pas être inférieur à 1")
    Integer salarie_maximum;

//    public List<Entreprise> getEntreprises() {
//        return entreprises;
//    }
//
//    public void setEntreprises(List<Entreprise> entreprises) {
//        this.entreprises = entreprises;
//    }

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    @JsonBackReference
    private Entreprise entreprise;

    @OneToMany(mappedBy = "convention")
    private List<Salarie> salaries;

    public Integer getSalarie_maximum() {
        return salarie_maximum;
    }

    public void setSalarie_maximum(Integer salarie_maximum) {
        this.salarie_maximum = salarie_maximum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getSubvention() {
        return subvention;
    }

    public void setSubvention(float subvention) {
        this.subvention = subvention;
    }

    public Integer getSalarieMax() {
        return salarie_maximum;
    }

    public void setSalarieMax(Integer salarieMax) {
        salarie_maximum = salarieMax;
    }

    public List<Salarie> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salarie> salaries) {
        this.salaries = salaries;
    }


}
