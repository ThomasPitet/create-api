package com.formation.apirestdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestionnaire global des exceptions.
 * Intercepte les exceptions levees par les controleurs
 * et retourne des reponses JSON structurees.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gere les erreurs de validation (@Valid).
     * Retourne un 400 avec la liste des champs en erreur.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> erreurs = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(erreur ->
                erreurs.put(erreur.getField(), erreur.getDefaultMessage())
        );

        Map<String, Object> reponse = new HashMap<>();
        reponse.put("timestamp", LocalDateTime.now().toString());
        reponse.put("statut", 400);
        reponse.put("erreur", "Validation echouee");
        reponse.put("details", erreurs);

        return ResponseEntity.badRequest().body(reponse);
    }

    /**
     * Gere toutes les autres exceptions non prevues.
     * Retourne un 500 avec un message generique.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {

        Map<String, Object> reponse = new HashMap<>();
        reponse.put("timestamp", LocalDateTime.now().toString());
        reponse.put("statut", 500);
        reponse.put("erreur", "Erreur interne du serveur");
        reponse.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponse);
    }
}
