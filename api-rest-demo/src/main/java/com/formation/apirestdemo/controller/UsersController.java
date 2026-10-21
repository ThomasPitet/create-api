package com.formation.apirestdemo.controller;

import com.formation.apirestdemo.model.Users;
import com.formation.apirestdemo.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utilisateurs")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> listerTous() {
        List<Users> utilisateurs = usersService.recupererTous();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> obtenirParId(@PathVariable Long id) {
        return usersService.recupererParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Users> creer(@Valid @RequestBody Users users) {
        Users usersCree = usersService.creer(users);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersCree);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> mettreAJour(@PathVariable Long id, @Valid @RequestBody Users users) {
        return usersService.mettreAJour(id, users)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        if (usersService.supprimer(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
