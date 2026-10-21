package com.formation.apirestdemo.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.*;

/**
 * Controleur REST Bonjour.
 * Exercice 1 — Hello World REST.
 */
@RestController
@RequestMapping("/api/v1/bonjour")
public class BonjourController {

    @GetMapping
    public Map<String, String> bonjour() {
        return Map.of("message", "Bonjour le monde !");
    }

    @GetMapping("/{prenom}")
    public Map<String, String> bonjourPrenom(@PathVariable String prenom) {
        return Map.of("message", "Bonjour " + prenom + " !");
    }

    @PostMapping
    public Map<String, String> bienvenue(@RequestBody Map<String, String> body) {
        String prenom = body.get("prenom");
        return Map.of("message", "Bienvenue " + prenom + " !");
    }
}
