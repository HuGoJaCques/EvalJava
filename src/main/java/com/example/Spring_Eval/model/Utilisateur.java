package com.example.Spring_Eval.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(length = 100, unique = true)
    @NotBlank(message = "L'email ne peut pas être vide")
    @Pattern(
            regexp = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$",
            message = "L'email doit être valide et contenir une extension d'au moins 2 caractères."
    )
    String email;

    @NotBlank(message = "Le mot de passe ne peut pas être vide")
    String password;

//    String role;

    @OneToOne
    @JoinColumn(name = "entreprise_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference
    private Entreprise entreprise;

    public Integer getId() {
        return id;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }




}
