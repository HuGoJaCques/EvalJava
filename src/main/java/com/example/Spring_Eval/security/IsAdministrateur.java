package com.example.Spring_Eval.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// Définition de la cible de l'annotation, qui peut être un type (classe, interface) ou une méthode
@Target({ElementType.METHOD, ElementType.TYPE})

// L'annotation sera disponible au moment de l'exécution
@Retention(RetentionPolicy.RUNTIME)

// Restreindre l'accès aux utilisateurs ayant le rôle 'ROLE_ADMIN'
@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATEUR','ROLE_ENTREPRISE')")
public @interface IsAdministrateur {
}
