package com.formation.apirestdemo.service;

import com.formation.apirestdemo.model.Users;
import com.formation.apirestdemo.repository.UsersRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> recupererTous() {
        return usersRepository.findAll();
    }

    public Optional<Users> recupererParId(Long id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> recupererParemail(String email) {
        return usersRepository.findByEmail(email);
    }

    public Users creer(Users users) {
        users.setId(null);
        return usersRepository.save(users);
    }

    public Optional<Users> mettreAJour(Long id, Users usersModifie) {
        return usersRepository.findById(id)
                .map(usersExistant -> {
                    usersExistant.setNom(usersModifie.getNom());
                    usersExistant.setPrenom(usersModifie.getPrenom());
                    usersExistant.setEmail(usersModifie.getEmail());
                    usersExistant.setAge(usersModifie.getAge());
                    return usersRepository.save(usersExistant);
                });
    }

    public boolean supprimer(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
