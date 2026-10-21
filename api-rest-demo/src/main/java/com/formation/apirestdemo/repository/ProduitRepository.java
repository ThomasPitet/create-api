package com.formation.apirestdemo.repository;

import com.formation.apirestdemo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour l'entite Produit.
 * En heritant de JpaRepository, Spring genere automatiquement
 * les methodes CRUD : findAll(), findById(), save(), deleteById(), etc.
 *
 * Pas besoin d'ecrire l'implementation : Spring Data le fait pour nous.
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    /**
     * Recherche des produits dont le nom contient la chaine donnee (insensible a la casse).
     * Spring Data genere automatiquement la requete SQL a partir du nom de la methode.
     * Equivalent SQL : SELECT * FROM produits WHERE LOWER(nom) LIKE LOWER('%nom%')
     */
    List<Produit> findByNomContainingIgnoreCase(String nom);

    /**
     * Recherche des produits dont le prix est inferieur ou egal au montant donne.
     * Equivalent SQL : SELECT * FROM produits WHERE prix <= ?
     */
    List<Produit> findByPrixLessThanEqual(Double prix);
}
