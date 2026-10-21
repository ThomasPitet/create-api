package com.formation.apirestdemo.service;

import com.formation.apirestdemo.model.Produit;
import com.formation.apirestdemo.repository.ProduitRepository;
import com.formation.apirestdemo.service.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service contenant la logique metier pour les produits.
 * Le service est le chef d'orchestre : il coordonne les appels
 * au repository et applique les regles metier.
 */
@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final NotificationService notificationService;

    public ProduitService(ProduitRepository produitRepository,
            @Qualifier("consoleNotificationService") NotificationService notificationService) {
        this.produitRepository = produitRepository;
        this.notificationService = notificationService;
    }

    /**
     * Retourne tous les produits.
     */
    public List<Produit> recupererTous() {
        return produitRepository.findAll();
    }

    /**
     * Retourne un produit par son ID.
     * 
     * @return Optional vide si le produit n'existe pas.
     */
    public Optional<Produit> recupererParId(Long id) {
        return produitRepository.findById(id);
    }

    /**
     * Cree un nouveau produit.
     * 
     * @param produit Le produit a creer (sans ID).
     * @return Le produit cree (avec ID genere).
     */
    public Produit creer(Produit produit) {
        // On s'assure que l'ID est null pour forcer une creation (pas une mise a jour)
        produit.setId(null);
        notificationService.notifier("stock", "Nouveau produit : " + produit.getNom());
        return produitRepository.save(produit);
    }

    /**
     * Met a jour un produit existant.
     * 
     * @param id             L'ID du produit a modifier.
     * @param produitModifie Les nouvelles valeurs.
     * @return Optional contenant le produit mis a jour, ou vide si l'ID n'existe
     *         pas.
     */
    public Optional<Produit> mettreAJour(Long id, Produit produitModifie) {
        return produitRepository.findById(id)
                .map(produitExistant -> {
                    produitExistant.setNom(produitModifie.getNom());
                    produitExistant.setDescription(produitModifie.getDescription());
                    produitExistant.setPrix(produitModifie.getPrix());
                    produitExistant.setStock(produitModifie.getStock());
                    return produitRepository.save(produitExistant);
                });
    }

    /**
     * Supprime un produit par son ID.
     * 
     * @return true si le produit existait et a ete supprime, false sinon.
     */
    public boolean supprimer(Long id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Recherche des produits par nom (recherche partielle, insensible a la casse).
     */
    public List<Produit> rechercherParNom(String nom) {
        return produitRepository.findByNomContainingIgnoreCase(nom);
    }
}
