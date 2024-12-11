package com.example.Spring_Eval.model;

import jakarta.persistence.*;
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

    String subvention;

    Integer salarie_maximum;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "convention")
    private List<Salarie> salaries;

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

    public String getSubvention() {
        return subvention;
    }

    public void setSubvention(String subvention) {
        this.subvention = subvention;
    }

    public Integer getSalarieMax() {
        return salarie_maximum;
    }

    public void setSalarieMax(Integer salarieMax) {
        salarie_maximum = salarieMax;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Salarie> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salarie> salaries) {
        this.salaries = salaries;
    }
}
