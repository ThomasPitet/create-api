package com.formation.apirestdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de l'utilisateur est obligatoire")
    @Column(nullable = false)
    private String nom;

    @NotBlank(message = "Le prénom de l'utilisateur est obligatoire")
    @Column(nullable = false)
    private String prenom;

    @NotBlank(message = "L'email de l'utilisateur est obligatoire")
    @Column(nullable = false, unique = true)
    @Email(message = "L'email doit être valide")
    private String email;

    @Positive(message = "l'age doit être positif")
    @Column(nullable = false)
    private Integer age;

    public Users() {
    }

    public Users(String nom, String prenom, String email, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', email='" + email + "', age=" + age
                + "}";
    }

}
